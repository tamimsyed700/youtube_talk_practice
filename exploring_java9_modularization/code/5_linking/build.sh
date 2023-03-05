/bin/rm -rf myapp
jlink --module-path $JMODS:../output/mlib --add-modules com.agiledeveloper --add-modules math.visibility --output myapp
./myapp/bin/java --list-modules
./myapp/bin/java -m math.visibility