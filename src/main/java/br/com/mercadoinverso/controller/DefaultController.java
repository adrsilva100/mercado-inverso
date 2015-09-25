package br.com.mercadoinverso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.mercadoinverso.entities.User;

import br.com.mercadoinverso.config.security.SecurityUser;
import br.com.mercadoinverso.services.UserService;

//@Controller
public class DefaultController {

	private static UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		DefaultController.userService = userService;
	}

	public static User getCurrentUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String email = ((UserDetails) principal).getUsername();
			User loginUser = userService.findUserByEmail(email);
			return new SecurityUser(loginUser);
		}

		return null;
	}

	public boolean validaUsuarioLogado(){
		boolean isUsuarioLogado = false;

		if(getCurrentUser() != null){
			isUsuarioLogado = true;
		} 

		return isUsuarioLogado;
	}
}
