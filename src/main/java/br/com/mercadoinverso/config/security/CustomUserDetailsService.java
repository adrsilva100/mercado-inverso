package br.com.mercadoinverso.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mercadoinverso.entities.User;

import br.com.mercadoinverso.services.UserService; 


@Component 
public class CustomUserDetailsService implements UserDetailsService { 

	@Autowired 
	private UserService userService; 

	@Override 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
		User user = userService.findUserByEmail(userName); 
		if(user == null){ 
			throw new UsernameNotFoundException("UserName " + userName + " not found"); 
		} 

		return new SecurityUser(user); 
	} 
}