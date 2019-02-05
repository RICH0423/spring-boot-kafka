FROM openjdk:8-jdk-alpine

MAINTAINER Rich.Lee <rich.lee@deltaww.com>

# Install base packages
RUN apk update
RUN apk upgrade
RUN apk add ca-certificates && update-ca-certificates

# Change TimeZone to Taipei
RUN apk add --update tzdata
ENV TZ=Asia/Taipei

# Clean APK cache
RUN rm -rf /var/cache/apk/*

# Install Bash
RUN apk add --no-cache bash

WORKDIR /usr/local/spring-boot-kafka

ADD target/spring-boot-kafka-0.0.1.jar app.jar

EXPOSE 9000 9000

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar