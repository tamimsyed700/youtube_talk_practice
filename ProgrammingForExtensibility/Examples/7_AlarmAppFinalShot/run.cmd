@echo off
set monitoringEntity="%1"
IF %monitoringEntity% == "" goto usageinfo

java -DTheMonitoringEntity=%1 -classpath %CLASSPATH%;. Tester
goto finish

:usageinfo
echo Usage: run TheMonitoringEntityClassName
echo Example: run VisualAlarm
echo Example: run Alarm

:finish
pause
