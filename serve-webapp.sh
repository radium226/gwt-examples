#!/bin/bash
mvn clean package
java -jar "./target/dependency/webapp-runner.jar" "./target/index-1.0-SNAPSHOT.war"

