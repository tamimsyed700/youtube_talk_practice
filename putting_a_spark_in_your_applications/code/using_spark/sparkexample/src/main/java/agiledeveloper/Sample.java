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
        .setMaster("local[2]");

    JavaSparkContext javaSparkContext =
      new JavaSparkContext(sparkConf);

    final JavaRDD<String> lines = javaSparkContext.textFile("build.gradle");

    System.out.println(
      lines.map(line -> transform(line))
        .reduce((total, e) -> total + e));
  }

  private static int transform(String input) {
    System.out.println("Thread: " + Thread.currentThread());
    return input.length();
  }
}
