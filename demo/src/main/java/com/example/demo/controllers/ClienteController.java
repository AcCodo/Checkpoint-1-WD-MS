package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.ClienteModel;
import com.example.demo.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository cliRep;
	
	@RequestMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("cliente/index");
		
		model.addObject("listClis", cliRep.findAll());
		
		return model;
	}
	
	@GetMapping("/create")
	public String create() {
		return "cliente/create";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute("cliente") ClienteModel novoCliente) {
		
		cliRep.save(novoCliente);
		
		return "redirect:/cliente";
	}
	
}
