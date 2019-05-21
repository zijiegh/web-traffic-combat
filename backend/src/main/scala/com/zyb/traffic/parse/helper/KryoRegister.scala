package com.zyb.traffic.parse.helper

import com.esotericsoftware.kryo.Kryo
import com.zyb.iplocation.IpLocation
import com.zyb.traffic.parser.data.`object`._
import com.zyb.traffic.parser.data.`object`.dim._
import org.apache.spark.serializer.KryoRegistrator

/**
  * 指定使用kryo序列化机制在spark shuffle计算过程中序列化用到的java对象
  */

class KryoRegister extends KryoRegistrator {

  override def registerClasses(kryo: Kryo): Unit = {
    kryo.register(classOf[BaseDataObject])
    kryo.register(classOf[PvDataObject])
    kryo.register(classOf[HeartbeatDataObject])
    kryo.register(classOf[EventDataObject])
    kryo.register(classOf[McDataObject])
    kryo.register(classOf[TargetPageDataObject])

    kryo.register(classOf[AdInfo])
    kryo.register(classOf[BrowserInfo])
    kryo.register(classOf[ReferrerInfo])
    kryo.register(classOf[SiteResourceInfo])
    kryo.register(classOf[TargetPageInfo])

    kryo.register(classOf[IpLocation])
  }

}
