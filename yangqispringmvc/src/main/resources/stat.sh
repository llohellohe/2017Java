#!/bin/bash
PID=$(ps | grep java| grep com.yangqi.gc.GCDemo | awk '{print $1}')
echo $PID

ps | grep com.yangqi.gc.GCDemo

jstat -gcutil $PID 1000
