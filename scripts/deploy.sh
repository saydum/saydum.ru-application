#!/usr/bin/env bash

cd ../ && mvn clean package

echo 'Copy files...'

scp target/saydumru-0.0.1-SNAPSHOT.jar saydum:/root/app/

echo 'Restart server...'

ssh saydum << EOF

pgrep java | xargs kill -9
java -jar /root/app/saydumru-0.0.1-SNAPSHOT.jar

EOF

echo 'Bye'