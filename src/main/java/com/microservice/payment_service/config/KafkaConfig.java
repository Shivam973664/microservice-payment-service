package com.microservice.payment_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.microservice.payment_service.constants.KafkaConstants;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic getTopic() {
		return TopicBuilder
				.name(KafkaConstants.FIRST_TOPIC_NAME)
				.build();
	}

}
