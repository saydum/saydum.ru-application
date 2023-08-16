#!/usr/bin/env bash

# Frontend
scp -r ../web/src saydum:/root/app/web
scp -r ../web/index.html saydum:/root/app/web
scp -r ../web/package.json saydum:/root/app/web
scp -r ../web/package-lock.json saydum:/root/app/web
scp -r ../web/vite.config.js saydum:/root/app/web

ssh saydum << EOF
cd /root/app/web
npm install
npm run build
EOF

# Backend
cd ../
mvn clean package
scp target/saydumru-0.0.1-SNAPSHOT.jar saydum:/root/app/

# Server
ssh saydum << EOF
systemctl restart saydum
systemctl restart nginx
EOF
