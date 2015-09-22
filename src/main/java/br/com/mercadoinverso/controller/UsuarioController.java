package br.com.mercadoinverso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {

	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastrarUsuario(){
		return "cadastro-usuario";
	}
}
