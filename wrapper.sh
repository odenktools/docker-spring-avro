#!/bin/bash
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar app.jar
