/bin/rm -rf agiledeveloper
jlink --module-path $JMODS:../output/mlib --add-modules com.agiledeveloper --add-modules com.agiledeveloper.first --output agiledeveloper --launcher=agiledeveloper=com.agiledeveloper.first
./agiledeveloper/bin/java --list-modules
./agiledeveloper/bin/java -m com.agiledeveloper.first
./agiledeveloper/bin/agiledeveloper