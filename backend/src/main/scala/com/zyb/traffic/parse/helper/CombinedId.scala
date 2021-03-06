package com.zyb.traffic.parse.helper

case class CombinedId(profileId:Int,userId:String) {

  def encode: String = {
    val encodeStr = s"${profileId.hashCode().toString.last}${profileId}${CombinedId.SEPERATOR}${userId}"

    return encodeStr
  }

}
object CombinedId{
  private val SEPERATOR="@"

  def decode(encodeStr:String):CombinedId={
    val arr:Array[String]=encodeStr.split(SEPERATOR)
    if(arr.size==2){
      return CombinedId(arr(0).tail.toInt,arr(1))
    }
    return null
  }

}