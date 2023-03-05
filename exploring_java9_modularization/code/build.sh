/bin/rm -rf output

mkdir -p output/mlib

mkdir -p output/classes
javac -d output/classes `find 1_creating_module -name *.java`
jar -c -f output/mlib/agiledeveloper.jar -C output/classes .
/bin/rm -rf output/classes

mkdir -p output/classes
javac -p output/mlib -d output/classes `find 2_using_module -name *.java`
jar -c -f output/mlib/mathuser.jar --main-class com.agiledeveloper.user.User -C output/classes .
/bin/rm -rf output/classes

java -p output/mlib -m math.user
java -p output/mlib -m math.user/com.agiledeveloper.user.User

mkdir -p output/classes
javac -p output/mlib -d output/classes `find 3_visibility -name *.java`
jar -c -f output/mlib/visibility.jar --main-class com.agiledeveloper.visibility.User -C output/classes .
/bin/rm -rf output/classes
java -p output/mlib -m math.visibility

jdeps --module-path output/mlib -s output/mlib/visibility.jar

mkdir -p output/classes
javac -p output/mlib -d output/classes `find 4_implied_readability -name *.java`
jar -c -f output/mlib/second.jar --module-version 1.0.3 --main-class com.agiledeveloper.second.SecondUser -C output/classes .
/bin/rm -rf output/classes
java -p output/mlib -m math.second
                                
jar -p output/mlib -f output/mlib/agiledeveloper.jar --print-module-descriptor
jar -p output/mlib -f output/mlib/second.jar --print-module-descriptor