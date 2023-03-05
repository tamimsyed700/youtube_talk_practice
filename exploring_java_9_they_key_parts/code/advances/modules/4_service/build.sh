/bin/rm -rf output

mkdir -p output/mlib

mkdir -p output/classes

javac -d output/classes `find rates -name *.java`
jar -c -f output/mlib/rates.jar -C output/classes .
/bin/rm -rf output/classes

javac -p output/mlib -d output/classes `find vendor1 -name *.java`
jar -c -f output/mlib/vendorone.jar -C output/classes .
/bin/rm -rf output/classes

javac -p output/mlib -d output/classes `find vendor2 -name *.java`
jar -c -f output/mlib/vendortwo.jar -C output/classes .
/bin/rm -rf output/classes
                               
javac -p output/mlib -d output/classes `find ratefinder -name *.java`
jar -c -f output/mlib/ratefinder.jar -C output/classes .
/bin/rm -rf output/classes
                               
java -p output/mlib -m com.agiledeveloper.ratefinder/com.agiledeveloper.ratefinder.RateFinder