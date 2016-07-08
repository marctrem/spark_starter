package io.tremblay.spark_starter

import buildinfo.BuildInfo
import com.fasterxml.jackson.databind.ObjectMapper
import io.tremblay.spark_starter.utils.JobConfiguration
import org.apache.log4j.Logger
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}


object Application {

  val mapper = new ObjectMapper()
  val log = Logger.getLogger(Application.getClass)

  def main(args: Array[String]): Unit = {

    val userConfig: Map[String, String] = JobConfiguration.inPackagePropertyMap("appconf.properties")

    val sparkConf = new SparkConf()
      .setAppName(s"${BuildInfo.name} [${BuildInfo.version}]")

    val sc = SparkContext.getOrCreate(sparkConf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._



  }
}
