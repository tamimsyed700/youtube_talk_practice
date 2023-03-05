To run on multiple nodes, first start the master by running the program

start-master.sh

which is located in the sbin directory of spark.

Visit http://localhost:8080 to view the master running.

Then start a slave by running 

start-slave.sh spark://hostname:7077

where hostname is the hostname where master is running.

Start slaves on different machines.

Then to schedule the program to run, use the following program located in the bin directory of spark:

spark-submit --class classname --master spark://hostname:7077 nameOfTheJarFile.jar

For example, from within the directory putting_a_spark_in_your_applications/code/partitions/sparkexample run

spark-submit --class agiledeveloper.Sample --master spark://hostname:7077 build/libs/sparkexample.jar

Replace hostname with your hostname
