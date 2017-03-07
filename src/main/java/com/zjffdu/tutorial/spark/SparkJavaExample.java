//package com.zjffdu.tutorial.spark;
//
//import com.google.common.collect.Lists;
//import org.apache.pig.data.Tuple;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.api.java.function.Function;
//import org.apache.spark.rdd.RDD;
//import org.apache.spark.sql.DataFrame;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.Row$;
//import org.apache.spark.sql.SQLContext;
//import org.apache.spark.sql.types.DataType;
//import org.apache.spark.sql.types.DataTypes;
//import org.apache.spark.sql.types.StructType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import scala.collection.JavaConversions;
////import scala.collectio
//
///**
// * Created by jzhang on 12/23/16.
// */
//public class SparkJavaExample {
//
//  public static void main(String[] args) {
//    SparkConf conf = new SparkConf().setAppName("test").setMaster("local");
//    JavaSparkContext sc = new JavaSparkContext(conf);
//    SQLContext sqlContext = SQLContext.getOrCreate(sc.sc());
//
//    JavaConversions.asScalaBuffer(Lists.newArrayList((Object) "1", (Object) "2"));
//    List<Row> list = new ArrayList<Row>();
//    list.add(Row$.MODULE$.apply(
//        JavaConversions.asScalaBuffer(Lists.newArrayList((Object) "1", (Object) "2"))));
//    JavaRDD<Row> rdd = sc.parallelize(list);
//    StructType sType = new StructType()
//      .add("id", DataTypes.StringType)
//      .add("id2", DataTypes.StringType);
//
//    rdd.map(new Function<Row, Tuple>() {
//
//      @Override
//      public Tuple call(Row v1) throws Exception {
//        return null;
//      }
//    });
//    DataFrame df = sqlContext.createDataFrame(rdd, sType);
////    df.collect();
//    sqlContext.registerDataFrameAsTable(df, "df");
//    Row[] rows = sqlContext.sql("select * from df").collect();
//    for (Row row : rows) {
//      System.out.println(row);
//    }
//  }
//}
