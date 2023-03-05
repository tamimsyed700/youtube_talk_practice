/bin/rm -rf output

mkdir -p output/mlib

mkdir -p output/classes
javac -d output/classes `find first -name *.java`
jar -c -f output/mlib/first.jar -C output/classes .
/bin/rm -rf output/classes

mkdir -p output/classes
javac -d output/classes -classpath output/mlib/first.jar `find second -name *.java`
jar -c -f output/mlib/second.jar -C output/classes .
/bin/rm -rf output/classes
                                                                                             
echo "running both in the classpath"
java -classpath output/mlib/first.jar:output/mlib/second.jar com.agiledeveloper.second.Second

echo "running both in the modulepath"
java -p output/mlib -m second/com.agiledeveloper.second.Second

echo "running second in the modulepath and first in the classpath"
java -p output/mlib/second.jar -classpath output/mlib/first.jar -m second/com.agiledeveloper.second.Second

echo "running second in the classpath and first in the modulepath"
echo "That will not work"
#java -p output/mlib/first.jar -classpath output/mlib/second.jar com.agiledeveloper.second.Second

mkdir -p output/classes
javac -d output/classes -p output/mlib/second.jar `find third -name *.java`
jar -c -f output/mlib/third.jar -C output/classes .
/bin/rm -rf output/classes

echo "running third in the modulepath, second in the modulepath, first in the module path"
java -p output/mlib -m com.agiledeveloper.thethird/com.agiledeveloper.third.Third

echo "running third in the modulepath, second in the modulepath, first in the classpath"
java -p output/mlib/third.jar:output/mlib/second.jar -classpath output/mlib/first.jar -m com.agiledeveloper.thethird/com.agiledeveloper.third.Third

echo "running third in the modulepath, second in the classpath, first in the classpath"
java -p output/mlib/third.jar -classpath output/mlib/second.jar:output/mlib/first.jar -m com.agiledeveloper.thethird/com.agiledeveloper.third.Third
