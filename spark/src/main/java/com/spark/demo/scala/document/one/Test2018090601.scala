package com.spark.demo.scala.document.one

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 弹性分布式数据集 (RDDs)
  * Spark 核心的概念是 Resilient Distributed Dataset (RDD)：
  * 一个可并行操作的有容错机制的数据集合。
  */
object Test2018090601 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Test2018090601").setMaster("local")
    val sc =new SparkContext(conf)

    /**
      * 有 2 种方式创建 RDDs：
      * 第一种是在你的驱动程序中并行化一个已经存在的集合；
      */
    val data = Array(1, 2, 3, 4, 5)
    val distData = sc.parallelize(data)
    distData.reduce((a, b) => a + b)

    /**
      * 另外一种是引用一个外部存储系统的数据集，
      * 例如共享的文件系统，HDFS，HBase或其他 Hadoop 数据格式的数据源。
      * 文本文件 RDDs 可以使用 SparkContext 的 textFile 方法创建。
      * 在这个方法里传入文件的 URI (机器上的本地路径或 hdfs://，s3n:// 等)
      * 然后它会将文件读取成一个行集合
      */
//    val distFile = sc.textFile("data.txt")
//    distFile.map(s => s.length).reduce((a, b) => a + b)

    /**
      * RDDs 支持 2 种类型的操作：
      * 转换(transformations) 从已经存在的数据集中创建一个新的数据集；
      * 动作(actions) 在数据集上进行计算之后返回一个值到驱动程序。
      */
    val lines = sc.textFile("data.txt")
    val lineLengths = lines.map(s => s.length)
    val totalLength = lineLengths.reduce((a, b) => a + b)
  }


}
