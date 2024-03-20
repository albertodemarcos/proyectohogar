package com.home.sso.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.home.sso.config.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    //private static final String SSO_ENTRY_POINT = "http://localhost:8080/sso/login";
	
	@Autowired
    private CustomUserDetailsService userDetailsService;

	@Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity ) throws Exception {
        
		httpSecurity 
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((requests) -> {
				requests.requestMatchers("/api/**", "/api/auth/**").permitAll();
				requests.anyRequest().authenticated();
			})
			//.exceptionHandling(handling -> handling.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("http://localhost:8080/sso/login")))
			.sessionManagement( session -> {
				session.maximumSessions(1);
				session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS );
			} )
			.formLogin((form) -> form.disable())
			.httpBasic( http -> http.disable() );
		
        return httpSecurity .build();
    }
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        
    	
    	return authenticationConfiguration.getAuthenticationManager();
    }

    /*@Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/api/sso/auth/login");
    }*/
    
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }
	
	/*@Bean
	UserDetailsService userDetailsService() {
	    UserDetails user = User.withUsername("user")
	            .password(passwordEncoder().encode("password"))
	            .roles("USER")
	            .build();
	    UserDetails admin = User.withUsername("administrador")
	            .password(passwordEncoder().encode("administrador"))
	            .roles("ADMIN")
	            .build();
	    return new InMemoryUserDetailsManager(user, admin);
	
	}*/
	
	/*.logout((logout) -> logout
	.permitAll()
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    .logoutSuccessUrl("/login?logout")
    .deleteCookies("JSESSIONID")
    .invalidateHttpSession(true)			
)*/;
}
