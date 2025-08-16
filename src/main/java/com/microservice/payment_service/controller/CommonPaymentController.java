package com.microservice.payment_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.payment_service.service.KafkaService;

@RestController
public class CommonPaymentController {
	
	Logger logger = LoggerFactory.getLogger(CommonPaymentController.class);
	
	@Autowired
	private KafkaService kafkaService;

	@GetMapping(value="/paymentoption")
	public ResponseEntity<List<String>> getPaymentOption(){
		logger.info("In the Payment Service Calling GetPayment Option method");
		return ResponseEntity.ok(List.of("Credit Card","Debit Card", "UPI"));
	}
	
	
	@PostMapping("/lastLocation")
	public ResponseEntity<Boolean> sendLocation(@RequestParam("location") String location){
		boolean sendSuccesffully = this.kafkaService.updateTopic(location);
		return ResponseEntity.status(HttpStatus.CREATED).body(sendSuccesffully);
	}
	
}
