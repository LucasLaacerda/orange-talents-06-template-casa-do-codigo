package br.com.zupacademy.lucaslacerda.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lucaslacerda.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.lucaslacerda.casadocodigo.model.Categoria;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaForm form) {
		
		Categoria categoria = form.toModel(form);	
		categoriaRepository.save(categoria);	
		return ResponseEntity.ok().build();		
	}
	
}
