package com.recode.devAgensApi.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig{

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeHttpRequests(requests-> requests
					 // .antMatchers(HttpMethod.GET, "/destinos/**")
					//.antMatchers(HttpMethod.GET, "/pacotes/**").permitAll()
					//.antMatchers(HttpMethod.GET, "/destino/**").hasRole("ADMIN")
					//.antMatchers(HttpMethod.GET, "/pacote/**").permitAll()  
					//.antMatchers(HttpMethod.GET, "/usuarios/**").hasRole("USER")
					.anyRequest().authenticated()
					)
				/*
				 * .formLogin(form -> form .loginPage("/login") .permitAll())
				 */
			.logout(logout -> logout.permitAll());
			
	/*		.antMatchers(HttpMethod.GET, "/destinos/**").permitAll()
			.antMatchers(HttpMethod.GET, "/pacotes/**").permitAll()
			.antMatchers(HttpMethod.GET, "/usuarios/**").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.cors().disable()
			.csrf().disable();*/
			
			return http.build();
	}
	
	
	/*
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService);
	 * authProvider.setPasswordEncoder(passwordEncoder()); return authProvider; }
	 */
	 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
