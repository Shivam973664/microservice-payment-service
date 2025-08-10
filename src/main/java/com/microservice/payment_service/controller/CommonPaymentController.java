package com.microservice.payment_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonPaymentController {
	
	Logger logger = LoggerFactory.getLogger(CommonPaymentController.class);

	@GetMapping(value="/paymentoption")
	public ResponseEntity<List<String>> getPaymentOption(){
		logger.info("In the Payment Service Calling GetPayment Option method");
		return ResponseEntity.ok(List.of("Credit Card","Debit Card", "UPI"));
	}
}
