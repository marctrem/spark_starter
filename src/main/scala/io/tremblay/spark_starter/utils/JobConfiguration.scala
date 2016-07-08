package io.tremblay.spark_starter.utils

import java.net.URL
import java.util.Properties

import scala.collection.JavaConversions._


object JobConfiguration {

  def inPackagePropertyMap(resourceName: String): Map[String, String] = {

    // The default classloader won't help us it since this job, when loaded through spark-submit, will be loaded with a different one.
    val classLoader = JobConfiguration.getClass.getClassLoader
    val resourceStream = classLoader.getResource(resourceName).openStream()

    try {
      val props = new Properties()
      props.load(resourceStream)
      propertiesAsScalaMap(props).toMap
    }
    finally {
      resourceStream.close()
    }


  }
}
