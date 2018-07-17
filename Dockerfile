FROM nimmis/java:openjdk-8-jdk
MAINTAINER odenktools.com

COPY target/avro-consumer-0.0.1-SNAPSHOT.jar /opt/avro-consumer/app.jar
COPY wrapper.sh /opt/avro-consumer/
WORKDIR /opt/avro-consumer
RUN /bin/bash -c 'chmod +x wrapper.sh'
RUN /bin/bash -c 'touch /opt/avro-consumer/app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","app.jar"]
EXPOSE 8090
