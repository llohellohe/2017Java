#!/bin/bash
echo "GC Demo Start"

BASE_DIR="/Users/yangqi/Dropbox/code-dev/2017java/yangqispringmvc/src/main/java"

cd $BASE_DIR/com/yangqi/gc

javac *.java

echo "Compile complete"

echo "==============Compile Class is===================="
ls -l *.class

##OPTS="-Xmx128m -verbose:gc"
#OPTS="-Xmx64m -XX:+UseConcMarkSweepGC -XX:+PrintGC -XX:+PrintGCDetails " 
OPTS="-Xmx64m -XX:+UseG1GC -XX:+PrintGC -XX:+PrintGCDetails " 
echo "==============Start To Execute With JVM OPTS===================="
echo $OPTS

cd $BASE_DIR

java $OPTS com.yangqi.gc.GCDemo
