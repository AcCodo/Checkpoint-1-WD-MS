package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.CategoriaModel;
import com.example.demo.models.FornecedorModel;
import com.example.demo.models.ProdutoModel;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.FornecedorRepository;
import com.example.demo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository prodRep;
	
	@Autowired
	private CategoriaRepository categRep;
	
	@Autowired
	private FornecedorRepository fornRep;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/index");
		return model;
	}
	
	@GetMapping("/produtos")
	@ResponseBody
	public List<ProdutoModel> getProdutos() {
		return prodRep.findAll();
	}
	
	@GetMapping("/create")
	public String create() {
		return "produto/create";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute("produto") ProdutoModel novoProduto) {
		
		prodRep.save(novoProduto);
		
		return "redirect:/produto";
	}
	
	@GetMapping("/categorias")
	@ResponseBody
	public List<CategoriaModel> getCategorias() {
		
		List<CategoriaModel> listCategs = categRep.findAll();
		
		return listCategs;		
	}
	
	@GetMapping("/fornecedores")
	@ResponseBody
	public List<FornecedorModel> getFornecedores() {
		
		List<FornecedorModel> listForns = fornRep.findAll();
		
		return listForns;		
	}
}
