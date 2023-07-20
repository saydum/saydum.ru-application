#!/usr/bin/env bash

cd ../ && mvn clean package

scp target/saydumru-0.0.1-SNAPSHOT.jar saydum:/root/app/

ssh saydum << EOF
systemctl restart saydum
EOF