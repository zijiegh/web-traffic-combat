package com.zyb.traffic.parse.handler

import com.zyb.traffic.parse.helper.CombinedId
import com.zyb.traffic.parser.data.`object`.BaseDataObject

class PartitionHandler(index:Int,
                       dataLog:Iterator[(CombinedId,Iterable[BaseDataObject])],
                       fileOutputPath:String,
                       etlDate:String
                      ) {

  def run():Unit={


  }

}
