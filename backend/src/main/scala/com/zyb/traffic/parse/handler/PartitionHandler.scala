package com.zyb.traffic.parse.handler

import com.zyb.traffic.parse.external.{HBaseUserVisitInfoComponent, UserVisitInfo}
import com.zyb.traffic.parse.helper.session.{SessionGenerator, UserSessionDataAggregator}
import com.zyb.traffic.parse.helper.{AvroOutputComponent, CombinedId}
import com.zyb.traffic.parser.data.`object`.BaseDataObject

/**
 * @Description :分区级处理
 * @param ： null
 * @Return :
 * @Author : mi
 * @Date : 2019/5/27 9:24
 */
class PartitionHandler(index:Int,
                       dataLog:Iterator[(CombinedId,Iterable[BaseDataObject])],
                       fileOutputPath:String,
                       etlDate:String
                      ) extends SessionGenerator with AvroOutputComponent with HBaseUserVisitInfoComponent {
  //一个user的开始的serverSessionId
  private var serverSessionIdStart = index.toLong + System.currentTimeMillis() * 1000

  def run():Unit={
    //每grouped 每512切割成1个批次(等同sliding方法)
      dataLog.grouped(512).foreach { case currentBatch:(CombinedId,Iterable[BaseDataObject])=>{
        val ids=currentBatch.map(_._1)
        val userVisitInfos=retrieveUsersVisitInfo(ids)

        val persistUserVisitInfoBuilder=Vector.newBuilder[UserVisitInfo]
        currentBatch.foreach { case (userId, dataObjects) => {
          //dataobjects按访问时间升序排列
          val sortedObgSeq=dataObjects.toSeq.sortBy(_.getServerTime.getTime)

          //切割会话
          val sessionData=groupDataObjects(sortedObgSeq)

          //聚合计算
          val aggregator = new UserSessionDataAggregator(userId, serverSessionIdStart, userVisitInfos.get(userId))
          val (userVisitInfo, records) = aggregator.aggregate(sessionData)
          persistUserVisitInfoBuilder += userVisitInfo
          serverSessionIdStart += sessionData.size

          }

        }


      }
    }

  }

}
