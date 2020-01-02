#!/bin/bash
#
#  Auto build shell script
#

profile="release" # release 表示发布版本， debug 调试版本

# 此处需要设置或修改MAVEN_OPTS，否则在执行mvn install命令时可能会出现OutOfMemoryError错误
export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=128m -XX:MaxMetaspaceSize=128m"

mvn clean install -Dmaven.test.skip=true -Dmaven.compile.fork=true -U -P${profile}
