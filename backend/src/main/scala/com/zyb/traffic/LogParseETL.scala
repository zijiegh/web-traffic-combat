package com.zyb.traffic

import com.zyb.traffic.parse.handler.LogParse
import com.zyb.traffic.parse.helper.CombinedId
import com.zyb.traffic.parse.{CombinedId, KryoRegister}
import com.zyb.traffic.parser.data.`object`.BaseDataObject
import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.rdd.RDD
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object LogParseETL {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf()
    if(!conf.contains("spark.master")) conf.setMaster("local")

    //指定kryo序列化及注册器
    conf.set("spark.serializer",classOf[KryoSerializer].getName)
    conf.set("spark.kryo.registrator",classOf[KryoRegister].getName)

    //输入路径 conf用户自定义参数必须以spark. 开头，，否则会被过滤掉
    val preParsedFileDir=conf.get("spark.web.traffic.preParsedFileDir","hdfs://hmaster:9999/user/hive/warehouse/traffic.db/rawlog")
    //输出路径
    val parsedFileDir=conf.get("spark.web.traffic.parsedFileDir","hdfs://hmaster:9999/user/hadoop/combat/web_traffic/parsed")
    //ETL Date
    val etlDate=conf.get("spark.web.traffic.etlDate","20190521")
    //分区数
    val partitions=conf.get("spark.web.traffic.partitions","4").toInt

    conf.setAppName(s"LogParseETL-${etlDate}")

    val spark=SparkSession.builder()
      .config(conf)
      .getOrCreate()

    //hive是分区表
    val inPath=s"${preParsedFileDir}/year=${preParsedFileDir.substring(0,4)}/month=${preParsedFileDir.substring(4,6).toInt}/day=${preParsedFileDir.substring(6,8).toInt}"
    val preParsedData:RDD[Row]=spark.read.parquet(inPath).rdd

    //解析返回的Seq可能有多个元素，需要展平
    val parsedRDD:RDD[(CombinedId,BaseDataObject)]=preParsedData.map(preParsedLogRow2Obj).flatMap(LogParse.parse)

    /**
      * WebLogParser.parse转换后数据为：
      * (CombinedId(profileId1,user1), BaseDataObject(profileId1,user1,pv,client_ip.....))
      * (CombinedId(profileId1,user1), BaseDataObject(profileId1,user1,mc,client_ip.....))
      * (CombinedId(profileId2,user2), BaseDataObject(profileId2,user2,pv,client_ip.....))
      *  ............
      *  (CombinedId(profileId3,user3), BaseDataObject(profileId3,user3,ev,client_ip.....))
      *  (CombinedId(profileIdn,usern), BaseDataObject(profileIdn,usern,pv,client_ip.....))
      */

    //聚合处理session数据
    parsedRDD.groupByKey(new HashPartitioner(partitions)).mapPartitionsWithIndex(
      (index:Int,iterator:Iterator[(CombinedId,Iterable[BaseDataObject])])=>{
      //groupByKey后的每一个分区的数据为：
      /**
        * 转换后数据为：
        * (CombinedId(profileId1,user1), List(BaseDataObject(profileId1,user1,pv,client_ip.....),
        *                                     BaseDataObject(profileId1,user1,mc,client_ip.....)))
        * (CombinedId(profileId2,user2), List(BaseDataObject(profileId2,user2,pv,client_ip.....),
        *                                     BaseDataObject(profileId2,user2,mc,client_ip.....),
        *                                     BaseDataObject(profileId2,user2,ev,client_ip.....)
        *                                     BaseDataObject(profileId2,user2,hb,client_ip.....)))
        *  ............
        *  (CombinedId(profileId3,user3), List(BaseDataObject(profileId3,user3,ev,client_ip.....)))
        *  (CombinedId(profileIdn,usern), List(BaseDataObject(profileIdn,usern,pv,client_ip.....),
        *                                      BaseDataObject(profileIdn,usern,mc,client_ip.....),
        *                                      BaseDataObject(profileIdn,usern,pv,client_ip.....)))
        */
      //处理分区数据的handler对象
      println("")
      //必须要有返回，此处返回空
      Iterator[Unit]()
    }).foreach((_:Unit)=>{}) //foreach触发actiion，尽管是空跑，但是触发了其中handler的run()操作

    spark.stop()

  }

  /**
   * @Description :将Row对象转为LogPreparser
   * @param ： row
   * @Return : com.zyb.traffic.LogPreparser
   * @Author : mi
   * @Date : 2019/5/21 13:57
   */
  def preParsedLogRow2Obj(row:Row):LogPreparser={
    val p:LogPreparser=new LogPreparser()
    p.setProfileId(row.getAs[Int]("profileId"))
    p.setClientIp(row.getAs[String]("clientIp"))
    p.setCommand(row.getAs[String]("command").toString)
    p.setMethod(row.getAs[String]("method"))
    p.setQueryString(row.getAs[String]("queryString"))
    p.setServerIp(row.getAs[String]("serverIp"))
    p.setServerPort(row.getAs[Int]("serverPort"))
    p.setServTime(row.getAs[String]("ServTime"))
    p.setUriStem(row.getAs[String]("uriStem"))
    p.setUserAgent(row.getAs[String]("userAgent"))

    return p
  }


}
