package com.odenktools.spring.kafka.avroconsumer.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {

	private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	private CountDownLatch getLatch() {

		return latch;
	}

	@KafkaListener(topics = {"kfk-api_keys"}, containerFactory = "kafkaListenerContainerFactory")
	public void receive(GenericRecord record) {

		System.out.println(String.format("All records = %s", record.toString()));
		LOG.debug("All records ='{}'", record);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = objectMapper.readTree(record.toString());
			String keyCode = jsonNode.get("key_code").asText();
			String secretKey = jsonNode.get("secret_key").asText();
			System.out.println(String.format("keyCode, secretKey: %s %s", keyCode, secretKey));
			System.out.println(String.format("All records = %s", record.toString()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		getLatch().countDown();
	}

	@KafkaListener(topics = {"kfk-companies"})
	public void receiveCompanies(GenericRecord record) {

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = objectMapper.readTree(record.toString());
			String email = jsonNode.get("email").asText();
			String phoneNumber = jsonNode.get("phone_number").asText();
			System.out.println(String.format("email , phoneNumber: %s %s", email, phoneNumber));
			System.out.println(String.format("All records = %s", record.toString()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		getLatch().countDown();
	}
}
