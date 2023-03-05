The code example here shows one algorithm for page rank. More important, it 
shows how to send messages across nodes/partitions.

The program runs on one node, but different partitions.

To run PageRank, type

./gradlew runPageRank

To run RandomWalk, type

./gradlew runRandomWalk

If you like to run on different nodes, please follow these steps:

Run ./startMaster.sh to start the master.

On each machine you like to start the slave, run

./start-slaves.sh

Replace Agility with the host name where the Master is running.

In the code PageRank.scala, comment out the line .setMaster("local[8]"), like so

//.setMaster("local[8]")

Save the code.

Then run

./runOnNodes.sh