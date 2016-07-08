package wordcount

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object wordcount {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("wordcount").setMaster("local")
    val sc = new SparkContext(conf)

val textFile = sc.textFile("/home/shubham/spark/big.txt")
val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1))
                 .reduceByKey(_ + _)
counts.saveAsTextFile("/home/shubham/spark/wordcount")

  }
  
}