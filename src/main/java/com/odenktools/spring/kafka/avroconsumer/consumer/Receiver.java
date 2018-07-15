package com.odenktools.spring.kafka.avroconsumer.consumer;

import com.odenktools.spring.kafka.avroconsumer.models.ApiKey;
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

	@KafkaListener(topics = {"dbserver1.public.api_keys"}, containerFactory = "kafkaListenerContainerFactory")
	public void receive(ConsumerRecord record) {

		System.out.println(record.toString());
		LOG.info("received message ='{}'", record.value());
		System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", "ssss", record.partition(), record.value()));
		getLatch().countDown();
	}
}
