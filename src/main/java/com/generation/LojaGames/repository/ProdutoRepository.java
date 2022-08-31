package com.generation.LojaGames.repository;

import java.util.Optional;

import javax.validation.Valid;

import com.generation.LojaGames.model.Produto;

public class ProdutoRepository {

	public Object save(@Valid Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Optional<Produto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findAllByNomeContainingIgnoreCase(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
