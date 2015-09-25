package br.com.mercadoinverso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HttpErrorController {

	@RequestMapping(value="/error-404", method=RequestMethod.GET)
	public String error404(){
		return "page-error-404";
	}
}
