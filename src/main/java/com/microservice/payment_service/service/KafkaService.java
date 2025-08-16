package com.microservice.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.microservice.payment_service.constants.KafkaConstants;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public boolean updateTopic(String location) {
		this.kafkaTemplate.send(KafkaConstants.FIRST_TOPIC_NAME, location);
		return true;
	}

}
