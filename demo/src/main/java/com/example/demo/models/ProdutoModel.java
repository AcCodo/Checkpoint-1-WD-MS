package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	private double preco;
	private Long categoriaId;
	private Long fornecedorId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public long getCategoria() {
		return categoriaId;
	}
	public void setCategoria(long categoria) {
		this.categoriaId = categoria;
	}
	public long getFornecedor() {
		return fornecedorId;
	}
	public void setFornecedor(long fornecedor) {
		this.fornecedorId = fornecedor;
	}
	
}
