./gradlew jar

/opt/spark/spark-2.1.0-bin-hadoop2.7/bin/spark-submit \
  --class pagerank.PageRank \
  --master spark://Agility:7077 \
  ./build/libs/pagerank-1.0.jar


