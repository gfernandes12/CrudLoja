package com.generation.LojaGames.controller;

public class CategoriaController {

	import java.util.List;
mport java.util.Optional;

port javax.validation.Valid;


ort org.springframework.beans.factory.annotation.Autowired;
i
rt org.springframework.http.HttpStatus;
im
t org.springframework.http.ResponseEntity;
imp
 org.springframework.web.bind.annotation.CrossOrigin;
impo
org.springframework.web.bind.annotation.DeleteMapping;
impor
rg.springframework.web.bind.annotation.GetMapping;
import
g.springframework.web.bind.annotation.PathVariable;
import 
.springframework.web.bind.annotation.PostMapping;
import o
springframework.web.bind.annotation.PutMapping;
import or
pringframework.web.bind.annotation.RequestBody;
import org
ringframework.web.bind.annotation.RequestMapping;
import org.
ingframework.web.bind.annotation.ResponseStatus;
import org.s
ngframework.web.bind.annotation.RestController;
import org.sp
gframework.web.server.ResponseStatusException;

import com.g

tion.lojagames.model.Categoria;
import com.gene
ion.lojagames.repository.CategoriaRepository;

	@RestController
	@RequestMapping("/categorias")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class CategoriaController {
		
		@Autowired
		private CategoriaRepository categoriaRepository;
		
		@GetMapping
		public ResponseEntity<List<Categoria>> getAll(){
			return ResponseEntity.ok(categoriaRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> getById(@PathVariable Long id){
			return categoriaRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}

		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<Categoria>> getByTitle(@PathVariable
				String descricao){
				return ResponseEntity.ok(categoriaRepository
				.findAllByDescricaoContainingIgnoreCase(descricao));
		}

		@PostMapping
		public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.CREATED)
			.body(categoriaRepository.save(categoria));
		}
		
		@PutMapping
		public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){
			return categoriaRepository.findById(categoria.getId())
			.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
			.body(categoriaRepository.save(categoria)))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
		
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			Optional<Categoria> tema = categoriaRepository.findById(id);
			
			if(tema.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
			categoriaRepository.deleteById(id);
		}
	
}
