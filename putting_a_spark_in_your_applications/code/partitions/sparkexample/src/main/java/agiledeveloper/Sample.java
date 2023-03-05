package agiledeveloper;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class Sample {
  public static void main(String[] args) {
    SparkConf sparkConf =
      new SparkConf()
        .setAppName("sparksample")
        .setMaster("local[32]");

    JavaSparkContext javaSparkContext =
      new JavaSparkContext(sparkConf);

    Timeit.code(() ->
        System.out.println(
          javaSparkContext.textFile("../inputfile.txt")
           .flatMap(line -> Arrays.asList(line.split(" ")).iterator())
           .filter(word -> word.equals("the"))
           .map(word -> 1)
           .reduce((total , e) -> total + e)));
  }
}