package com.home.sso.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.sso.web.dtos.LoginRequest;
import com.home.sso.web.dtos.LoginResponse;

@RestController
@RequestMapping("/api/sso/auth")
public class AuthController {

	private final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthenticationManager authenticationManager;

	public AuthController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		
		logger.info("Se va a logar el usuario con username={}", loginRequest.getUsername() );
		
		AbstractAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		
		Authentication auth = authenticationManager.authenticate(login);
		
		LoginResponse response = null;
		
		if(!auth.isAuthenticated()) {
			
			logger.error("El usuario con username={} no ha sido autenticado", loginRequest.getUsername() );
			
			response = new LoginResponse("-1", "Error al autenticarse");
			
			return ResponseEntity.badRequest().body(response);
		}
		
		response = new LoginResponse("1", "login correcto");
		
		return ResponseEntity.ok().body(response);
	}
}
