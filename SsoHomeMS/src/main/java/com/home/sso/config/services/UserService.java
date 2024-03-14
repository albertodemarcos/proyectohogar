package com.home.sso.config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDetails findUser(String username) {

		UserDetails admin = User.withUsername("administrador").password(passwordEncoder.encode("administrador"))
				.roles("ADMIN").build();

		return admin;
	}

}
