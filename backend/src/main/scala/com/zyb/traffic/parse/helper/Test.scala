package com.zyb.traffic.parse.helper

object Test {
  def main(args: Array[String]): Unit = {
    val str="20190501"
    println(str.substring(1,str.length))

    println(str.tail)
    println(s"${str.substring(0,4)} ${str.substring(4,6).toInt}")
  }
}
