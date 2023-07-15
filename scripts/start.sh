#!/usr/bin/env bash

cd ../
mvn clean package spring-boot:repackage
cp target/saydumru-0.0.1-SNAPSHOT.jar /root/upload
java -jar /root/upload/saydumru-0.0.1-SNAPSHOT.jar
