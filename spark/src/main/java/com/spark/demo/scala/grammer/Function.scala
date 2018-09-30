package com.spark.demo.scala.grammer

object Function {
  //定义一个方法
  //方法m2参数要求是一个函数，函数的参数必须是两个Int类型
  //返回值类型也是Int类型
  def m1(f:(Int,Int) => Int) : Int = {
    f(2,6)
  }

  //定义一个函数f1,参数是两个Int类型，返回值是一个Int类型
  val f1 = (x:Int,y:Int) => x + y
  //再定义一个函数f2
  val f2 = (m:Int,n:Int) => m * n

  //main方法
  def main(args: Array[String]): Unit = {
    //调用m1方法，并传入f1函数
    val r1 = m1(f1)

    println(r1)

    //调用m1方法，并传入f2函数
    val r2 = m1(f2)
    println(r2)
  }
}

