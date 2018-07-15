FROM openjdk:8-jre-alpine
MAINTAINER odenktools.com

COPY target/avro-consumer-0.0.1-SNAPSHOT.jar /opt/avro-consumer/
WORKDIR /opt/avro-consumer
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/avro-consumer/avro-consumer-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090
