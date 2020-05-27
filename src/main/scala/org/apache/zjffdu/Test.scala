package org.apache.zjffdu

import org.apache.spark.sql.SparkSession

object Test {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("test")
      .config("spark.sql.extensions", "org.apache.iceberg.spark.extensions.IcebergSparkSessionExtensions")
      .config("spark.sql.catalog.spark_catalog", "org.apache.iceberg.spark.SparkSessionCatalog")
      .config("spark.sql.catalog.spark_catalog.type", "hive")
      .config("spark.sql.catalog.local", "org.apache.iceberg.spark.SparkCatalog")
      .config("spark.sql.catalog.local.type", "hadoop")
      .config("spark.sql.catalog.local.warehouse", "/tmp/iceberg")
      .getOrCreate()

//    spark.sql("CREATE TABLE local.db.table (id bigint, data string) USING iceberg")
//    spark.sql("INSERT INTO local.db.table VALUES (1, 'a'), (2, 'b'), (3, 'c');")
//    spark.sql("select * from local.db.table").show()

    spark.read.format("iceberg")
      .load("/tmp/iceberg/db/table")
      .select("id")
      .filter("id=1")
      .show()

  }
}
