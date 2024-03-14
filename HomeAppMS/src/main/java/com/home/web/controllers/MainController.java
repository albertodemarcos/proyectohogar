package com.home.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.web.dtos.LoginResponse;

@RestController
@RequestMapping("/api")
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/main")
	public ResponseEntity<LoginResponse> viewDataMain() {

		logger.info("El usuario pide datos al viewDataMain");

		LoginResponse response = new LoginResponse("1", "se envian datos");

		return ResponseEntity.ok().body(response);

	}
	
	@GetMapping("/customers")
	public ResponseEntity<LoginResponse> viewDataCustomers() {

		logger.info("El usuario pide datos al viewDataMain");

		LoginResponse response = new LoginResponse("1", "se envian datos");

		return ResponseEntity.ok().body(response);

	}

}
