package br.com.zupacademy.lucaslacerda.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lucaslacerda.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.lucaslacerda.casadocodigo.model.Livro;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroRepository livroRepository;
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm form) {
		
		Livro livro = form.toModel(form,autorRepository,categoriaRepository);	
		livroRepository.save(livro);	
		return ResponseEntity.ok().build();	
	}
	
}
