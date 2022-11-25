package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override

		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 PasswordEncoder passwordEncoder=passwordEncoder();
			auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
			auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
			auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN","USER");
	}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.formLogin();
	
	http. authorizeRequests(). antMatchers("/save**/**","/delete**/**","/form**/**","/medecine**/**","/consultation**/**").hasRole("ADMIN");

	http. authorizeRequests(). antMatchers("/patients**/**","/RendezVous**/**","/consultation**/**").hasRole("USER");
	
		/*
		 * http .authorizeRequests() //c'est 3 methodes permettent de demander un
		 * authenti a tout nos resources .anyRequest() .authenticated();
		 */
	http.exceptionHandling().accessDeniedPage("/erros");
	  
	}
@Bean
public PasswordEncoder passwordEncoder() 
{
	return new BCryptPasswordEncoder();
}
}
