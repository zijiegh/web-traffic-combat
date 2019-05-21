package com.zyb.traffic.parse.handler

import java.util
import java.util.concurrent.ConcurrentHashMap

import com.zyb.traffic.metastore.api.impl.MongoProfileConfigManager
import com.zyb.traffic.parse.helper.CombinedId
import com.zyb.traffic.parser.data.`object`.{BaseDataObject, InvalidLogObject}
import com.zyb.traffic.parser.data.builder._
import com.zyb.traffic.parser.data.builder.helper.TargetPageAnalyzer
import com.zyb.traffic.parser.data.configuration.loader.impl.DefaultProfileConfigLoader
import com.zyb.traffic.{LogParser, LogParserSetting, LogPreparser}
import org.slf4j.LoggerFactory

object LogParse {
  private val logger=LoggerFactory.getLogger(LogParse.getClass)
  private val localExceptionCounters=new ConcurrentHashMap[String,Int]
  //nm：property name
  private val LOGGING_THRESHOLD_PER_EXCEPTION=Integer.getInteger("web.logparser.logging.exception.threshold",5000)

  /**
   * @Description :初始化parser
   * @param ：
   * @Return : com.zyb.traffic.LogParser
   * @Author : mi
   * @Date : 2019/5/21 9:51
   */
  private def parser():LogParser={
    val settingSets=new util.HashSet[String]()
    settingSets.add("pv")
    settingSets.add("mc")
    settingSets.add("ev")
    settingSets.add("hb")

    val logParserSetting= new LogParserSetting(settingSets)
    val logBuilders=new util.ArrayList[AbstractDataObjectBuilder]()
    logBuilders.add(new MouseClickDataObjectBuilder())
    logBuilders.add(new EventDataObjectBuilder)
    logBuilders.add(new HeartbeatDataObjectBuilder)

    val profileCfgManager=new MongoProfileConfigManager()
    val profileCfgService=new DefaultProfileConfigLoader(profileCfgManager)
    logBuilders.add(new PvDataObjectBuilder(new TargetPageAnalyzer(profileCfgService)))


    return new LogParser(logParserSetting,logBuilders)

  }

  /**
   * @Description :将预解析对象转为Log对象
   * @param ： prePasedLog
   * @Return : scala.collection.Seq<scala.Tuple2<com.zyb.traffic.parse.CombinedId,com.zyb.traffic.parser.data.object.BaseDataObject>>
   * @Author : mi
   * @Date : 2019/5/21 9:33
   */
  def parse(prePasedLog:LogPreparser):Seq[(CombinedId,BaseDataObject)]={
    val dataObjectBuilder=Vector.newBuilder[(CombinedId,BaseDataObject)]

    val parsedObjiects=LogParse.parse(prePasedLog)
    parsedObjiects.foreach{
      case baseObj:BaseDataObject=>{
        dataObjectBuilder += CombinedId(baseObj.getProfileId,baseObj.getUserId) -> baseObj
      }
      case invalidObj:InvalidLogObject=>{
        tryLogException("Invalid data object while parsing RequestInfo\n, details: ", new RuntimeException(invalidObj.getEvent))
      }
    }

    return dataObjectBuilder.result()
  }
/**
 * @Description :
 * @param ： errorMsg
 * @param ： ex
 * @Return : void
 * @Author : mi
 * @Date : 2019/5/21 9:50
 */

  private def tryLogException(errorMsg: String, ex: Exception): Unit = {
    val exceptionName = ex.getClass.getSimpleName
    val current = Option(localExceptionCounters.get(exceptionName)).getOrElse(0)
    localExceptionCounters.put(exceptionName, current + 1)
    if (current < LOGGING_THRESHOLD_PER_EXCEPTION)
      logger.error(errorMsg, ex)
  }

}
