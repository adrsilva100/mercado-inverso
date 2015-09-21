package br.com.mercadoinverso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DefaultController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("msg", "Hello World from Spring 4 MVCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
		return "index";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("msg", "Hello World Again, from Spring 4 MVCdasdsadsadasds");
		return "index";
	}
}
