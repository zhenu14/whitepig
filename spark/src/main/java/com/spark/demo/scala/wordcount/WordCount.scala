package com.spark.demo.scala.wordcount

import org.apache.spark.{SparkConf, SparkContext}


object WordCount {
  def main(args: Array[String]): Unit = {
    val config = new SparkConf().setAppName("kitty")
    config.setMaster("local")
    val sc = new SparkContext(config)
    val rdd = sc.textFile("file:///C:/Users/prayer/Desktop/1.txt")
    val wordCount = rdd.flatMap(_.split(" ")).map(x => (x,1)).reduceByKey(_+_)
    val wordSout = wordCount.map(x => (x._2,x._1)).sortByKey(false).map(x => (x._2,x._1))
    wordSout.saveAsTextFile("file:///C:/Users/prayer/Desktop/2.txt")
    sc.stop()
  }
}
