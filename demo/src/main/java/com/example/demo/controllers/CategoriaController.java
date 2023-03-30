package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.CategoriaModel;
import com.example.demo.repositories.CategoriaRepository;

@Controller
@RequestMapping("/produto/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categRep;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/categoria/index");
		
		List<CategoriaModel> listCateg = categRep.findAll();
		model.addObject("listCategs", listCateg);
		
		return model;
	}
	
	@GetMapping("/create")
	public String create() {
		return "produto/categoria/create";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute("categoria") CategoriaModel novaCategoria) {
		
		categRep.save(novaCategoria);
		
		return "redirect:/produto/categoria";
	}
	
}
