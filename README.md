# Spark Starter Project

This project provides a basis to build a Spark application that will run on EMR 4.7.1.

When adding new dependencies, make sure to check [Apache Hadoop 2.7.2 – Dependencies Report](https://hadoop.apache.org/docs/current/hadoop-mapreduce-client/hadoop-mapreduce-client-core/dependency-analysis.html) to avoid compatibility issues.
Whenever in need of a particular dependency which clashes with Apache Hadoop 2.7.2's own, consider creating a [Bootstrap Action](http://docs.aws.amazon.com/ElasticMapReduce/latest/DeveloperGuide/emr-plan-bootstrap.html).



# Packaging
```bash
sbt clean assembly
```
