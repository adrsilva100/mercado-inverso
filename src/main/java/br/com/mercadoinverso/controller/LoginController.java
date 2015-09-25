package br.com.mercadoinverso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController extends DefaultController{

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		String nomeView = "";
		if(validaUsuarioLogado()){
			nomeView = "redirect:/perfil/resumo";	
		}else{
			nomeView = "login";
		}
		
		return nomeView;
	}

	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public String loginFailure(Model model) {
		model.addAttribute("message_login_failure", "Usuário ou senha estão incorretos");
		return "login";
	}
}