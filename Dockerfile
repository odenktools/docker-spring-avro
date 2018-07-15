FROM nimmis/java:openjdk-8-jdk
MAINTAINER odenktools.com

COPY target/avro-consumer-0.0.1-SNAPSHOT.jar /opt/avro-consumer/
COPY wrapper.sh /opt/avro-consumer/
WORKDIR /opt/avro-consumer
RUN /bin/bash -c 'chmod +x wrapper.sh'
ENTRYPOINT ["/bin/bash"]
CMD ["wrapper.sh"]
EXPOSE 8090
