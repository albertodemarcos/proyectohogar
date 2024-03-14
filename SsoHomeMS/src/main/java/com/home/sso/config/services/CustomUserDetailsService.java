package com.home.sso.config.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    // @Lazy aquí evita la inicialización inmediata y resuelve la dependencia circular
    public CustomUserDetailsService(@Lazy UserService userService) {
        this.userService = userService;
    }
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
        
		if ( StringUtils.isBlank(username) ) {
            throw new UsernameNotFoundException("Usuario no encontrado o condición no cumplida");
        }
		
		UserDetails admin = this.userService.findUser(username);
		
	    return admin;
	}

	
	
	
	
	
	
	
}
