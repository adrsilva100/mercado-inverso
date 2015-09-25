package br.com.mercadoinverso.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mercadoinverso.entities.Role;
import com.mercadoinverso.entities.User;

import br.com.mercadoinverso.services.UserService; 


public class SecurityUser extends User implements UserDetails { 
	private static final long serialVersionUID = 1L; 
	
	@Autowired 
	private UserService userService;

	public SecurityUser(User user) { 
		if(user != null) { 
			this.setId(user.getId()); 
			this.setName(user.getName()); 
			this.setEmail(user.getEmail()); 
			this.setPassword(user.getPassword()); 
			this.setRoles(user.getRoles()); 
		}
	} 

	@Override 
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		Collection<GrantedAuthority> authorities = new ArrayList<>(); 
		Set<Role> userRoles = this.getRoles(); 

		if(userRoles != null) { 
			for (Role role : userRoles) { 
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName()); authorities.add(authority); 
			} 
		} 

		return authorities;
	}
	
	public User getUser(){
		User user = userService.findUserByEmail(getUsername());
		return user;
	}

	@Override 
	public String getPassword() { 
		return super.getPassword(); 
	} 

	@Override 
	public String getUsername() { 
		return super.getEmail(); 
	} 

	@Override 
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override 
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override 
	public boolean isCredentialsNonExpired() { 
		return true; 
	}

	@Override 
	public boolean isEnabled() { 
		return true; 
	}	
} 
