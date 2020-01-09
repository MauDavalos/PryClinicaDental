package com.dental.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dental.app.web.security.LoginSuccessHandler;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired //crear un objeto de esta clase dentro de la clase de arriba
	private LoginSuccessHandler successHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
		builder.inMemoryAuthentication()
		.withUser(users.username("admin1").password("123").roles("ADMIN"))
		.withUser(users.username("hernansiqui").password("123").roles("USER"))
		.withUser(users.username("mau").password("123").roles("USER"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/css/**","/js/**","/img/**","/scss/**","/fonts/**").permitAll()
		.antMatchers("/paciente/**").hasAnyRole("ADMIN","USER")
		.antMatchers("/doctor/**").hasAnyRole("ADMIN")
		.antMatchers("/insumo/**").hasAnyRole("ADMIN")
		.antMatchers("/prescripcion/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
			.formLogin().successHandler(successHandler)
			.loginPage("/login").permitAll()
		.and()
			.logout().permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/error_403")
		.and()
			.csrf().ignoringAntMatchers("/h2-console/**")
		.and()
			.headers().frameOptions().sameOrigin();
	
	}
	

}
