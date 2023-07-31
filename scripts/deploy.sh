#!/usr/bin/env bash

# Frontend
scp -r ../web/ saydum:/root/application/web

ssh saydum << EOF
npm install
npm run build
EOF

# Backend
cd ../
mvn clean package
scp target/saydumru-0.0.1-SNAPSHOT.jar saydum:/roo/application/

# Server
ssh saydum << EOF
systemctl restart saydum
systemctl restart nginx
EOF
