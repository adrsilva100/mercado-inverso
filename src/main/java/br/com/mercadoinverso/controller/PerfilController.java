package br.com.mercadoinverso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerfilController extends DefaultController{
	
	@RequestMapping(value="/perfil/alterarDadosPessoais", method=RequestMethod.GET)
	public String alterarCadastroDadosPessoais(){
		return "alterar-cadastro-dados-pessoais";
	}
	
	@RequestMapping(value="/perfil/resumo", method=RequestMethod.GET)
	public String resumo(){
		return "perfil-resumo";
	}
}
