package com.odenktools.spring.kafka.avroconsumer.consumer;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {

	private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {

		return latch;
	}

	@KafkaListener(topics = {"kfk-api_keys"}, containerFactory = "kafkaListenerContainerFactory")
	public void receive(GenericRecord record) {

		System.out.println(record.toString());
		LOG.info("received message ='{}'", record);
		//System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", "ssss", record.partition(), record.value()));
		getLatch().countDown();
	}
}
