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
import com.example.demo.models.FornecedorModel;
import com.example.demo.repositories.FornecedorRepository;

@Controller
@RequestMapping("/produto/fornecedor")
public class FornecedorController {

	@Autowired
	FornecedorRepository fornRep;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/fornecedor/index");
		
		List<FornecedorModel> listForns = fornRep.findAll();
		model.addObject("listForns", listForns);
		
		return model;
	}
	
	@GetMapping("/create")
	public String create() {
		return "produto/fornecedor/create";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute("categoria") FornecedorModel novoFornecedor) {
		
		fornRep.save(novoFornecedor);
		
		return "redirect:/produto/fornecedor";
	}
	
}
