#!/bin/sh
"${JAVA_HOME}"/bin/java -Dlogback.configurationFile=filelogging.xml -jar ../../target/jenkinsmonitor-0.1.1-jar-with-dependencies.jar
