//package com.zjffdu.tutorial.spark
//
//import _root_.java.io.FileInputStream
//import _root_.java.util.Properties
//
//import org.apache.commons.io.IOUtils
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
//import org.apache.spark.sql.SQLContext
//import org.apache.spark.sql.catalyst.util.GenericArrayData
//import org.apache.spark.sql.types.Decimal
//import org.apache.spark.storage.StorageLevel
//import org.apache.spark._
//
//import org.apache.spark.sql.types.Decimal
//import scala.reflect.runtime.universe._
//import org.apache.spark.sql.catalyst.expressions.GenericMutableRow
//
//
//import org.apache.spark.
//{SparkConf, SparkContext}
//import org.apache.spark.sql.catalyst.InternalRow
//import org.apache.spark.sql.catalyst.expressions.GenericMutableRow
//import org.apache.spark.sql.types._
//
//@SQLUserDefinedType(udt = classOf[AUDT])
//case class A(list: Seq[B])
//
//class AUDT extends UserDefinedType[A] {
//  override def sqlType: DataType = StructType(Seq(StructField("list", ArrayType(BUDT, containsNull = false), nullable = true)))
//
//  override def userClass: Class[A] = classOf[A]
//
//  override def serialize(obj: Any): Any = obj match {
//    case A(list) => val row = new GenericMutableRow(1)
//      row.update(0, new GenericArrayData (list.map (_.asInstanceOf[Any] ).toArray) )
//      row
//  }
//
//  override def deserialize(datum: Any): A = {
//    datum match {
//      case row: InternalRow => new A(row.getArray(0).toArray(BUDT).toSeq)
//    }
//  }
//}
//
//object AUDT extends AUDT
//
//@SQLUserDefinedType(udt = classOf[BUDT])
//case class B(text: Int)
//
//class BUDT extends UserDefinedType[B] {
//  override def sqlType: DataType = StructType(Seq(StructField("num", IntegerType, nullable = false)))
//
//  override def userClass: Class[B] = classOf[B]
//
//  override def serialize(obj: Any): Any = obj match {
//    case B(text) => val row = new GenericMutableRow(1)
//      row.setInt (0, text)
//      row
//  }
//
//  override def deserialize(datum: Any): B = {
//    datum match {
//      case row: InternalRow => new B(row.getInt(0))
//    }
//  }
//}
//
//object BUDT extends BUDT
//
//object SparkExample {
//  def main(args: Array[String]) = {
//    val col = Seq(new A(Seq(new B(1), new B(2))), new A(Seq(new B(3), new B(4))))
//    val sc = new SparkContext(new SparkConf().setMaster("local[1]").setAppName("TestSpark"))
//    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
//    import sqlContext.implicits._
//    val df = sc.parallelize(1 to 2 zip col).toDF("id", "b")
//    df.select("b").show()
//    df.collect().foreach(println)
//  }
//}