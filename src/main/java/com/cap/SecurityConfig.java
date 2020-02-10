package com.cap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	


	@Autowired
	private DataSource dataSource;

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// URLs matching for access rights
		
				.antMatchers("/login-user").hasAnyAuthority("USER")//.access("hasRole('USER')")
				.antMatchers("/login-seller","/login-seller/newproduct").permitAll()//.hasAnyAuthority("SELLER")//.access("hasRole('SELLER')")
				.antMatchers("/adminPage").hasAnyAuthority("ADMIN")//.access("hasRole('ADMIN')")
		
				.antMatchers("/resources/**","/static/**", "/css/**", "/js/**", "/images/**","/main","/welcome", "/login", "/login-user", "/register", "/save-user", "/seller-welcome", "/registerseller", "/save-seller", "/loginseller", "/login-seller").permitAll()
				
				
				.anyRequest().authenticated()
				.and()
				// form login
				.csrf().disable()
				.formLogin().loginPage("/login").successHandler(customSuccessHandler)
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
				.and()
				.logout().permitAll();
	}

}
