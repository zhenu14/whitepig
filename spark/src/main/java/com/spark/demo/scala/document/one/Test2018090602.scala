package com.spark.demo.scala.document.one

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * RDDs 支持 2 种类型的操作：
  * 转换(transformations) 从已经存在的数据集中创建一个新的数据集；
  * 动作(actions) 在数据集上进行计算之后返回一个值到驱动程序。
  */
object Test2018090602 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test2018090602").setMaster("local")
    val sc =new SparkContext(conf)

    /**
      * 使用键值对
      * 虽然很多 Spark 操作工作在包含任意类型对象的 RDDs 上的，
      * 但是少数几个特殊操作仅仅在键值(key-value)对 RDDs 上可用。
      * 最常见的是分布式 "shuffle" 操作，例如根据一个 key 对一组数据进行分组和聚合。
      */
    val lines = sc.textFile("data.txt")
    val pairs = lines.map(s => (s, 1))
    val counts = pairs.reduceByKey((a, b) => a + b)
    
  }

  /**
    * Spark 的 API 很大程度上依靠在驱动程序里传递函数到集群上运行。
    * 这里有两种推荐的方式：
    * 匿名函数 (Anonymous function syntax)，可以在比较短的代码中使用。
    * 全局单例对象里的静态方法。
    * 它可能传递的是一个类实例里的一个方法引用(而不是一个单例对象)，这里必须传送包含方法的整个对象
    */
  class MyClass {
    def func1(s: String): String = { "hello : " + s }
    def doStuff(rdd: RDD[String]): RDD[String] = {
      rdd.map(func1)
    }
  }

}
