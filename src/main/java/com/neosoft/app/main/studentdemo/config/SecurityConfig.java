package com.neosoft.app.main.studentdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1000) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailService ;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();	
		
		  http .httpBasic() .and() .authorizeRequests()
		  .antMatchers("/adminAcess/**").permitAll() .and() .authorizeRequests()
		  .antMatchers("/studentAcess/**").access("hasRole('STUDENT')")
		  .anyRequest().authenticated() .and() .formLogin() .permitAll();
		  
		 
			/*
			 * http .httpBasic() .and() .authorizeRequests()
			 * .antMatchers("/adminAcess/**").access("hasRole('ADMIN')").
			 * antMatchers("/studentAcess/**").access("hasRole('STUDENT')"). and()
			 * .formLogin() .permitAll();
			 */
		  /*http.authorizeRequests()
          .antMatchers("/adminAcess/**").hasAnyAuthority("ADMIN")
          .antMatchers("/studentAcess/**").hasAnyAuthority("STUDENT")
          .anyRequest().authenticated()
          .and()
          .formLogin().permitAll()
          .and()
          .logout().permitAll()
          .and()
          .exceptionHandling().accessDeniedPage("/403")
          ;*/
		
	}
	
	@Bean
	BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}
