package com.disney_api.app.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.disney_api.app.servicios.UsuarioServicio;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServicio usuarioServicio;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
								.antMatchers("/css/*", "/js/*", "/img/*", "/**" ).permitAll()
								.and().formLogin()
												.loginPage("/login")
												.loginProcessingUrl("/logincheck")
												.usernameParameter("usuario")
												.passwordParameter("contrasena")
												.defaultSuccessUrl("/")
												.failureUrl("/login?error=error")
												.permitAll()
								.and().logout()
												.logoutUrl("/logout")
												.logoutSuccessUrl("/login?logout")
												.permitAll()
								.and()
								.csrf()
										.disable();
							
	}

}
