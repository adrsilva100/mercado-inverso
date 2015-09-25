package br.com.mercadoinverso.config.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private CustomUserDetailsService customUserDetailsService;

	@Override 
	protected void configure(AuthenticationManagerBuilder registry) throws Exception { 
		registry.userDetailsService(customUserDetailsService); 
		registry.authenticationProvider(authProvider());
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/perfil/**").authenticated()
		.and().formLogin().loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username").passwordParameter("j_password")
		.loginPage("/login").defaultSuccessUrl("/perfil/resumo").failureUrl("/login-error").permitAll()
		.and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/").invalidateHttpSession(true).permitAll()
		.and().exceptionHandling().accessDeniedPage("/error-403")
		.and().csrf().disable();
	}
}
