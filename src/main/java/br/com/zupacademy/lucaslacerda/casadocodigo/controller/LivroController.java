package br.com.zupacademy.lucaslacerda.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zupacademy.lucaslacerda.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.lucaslacerda.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.lucaslacerda.casadocodigo.model.Livro;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroRepository livroRepository;
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	@Cacheable(value="listaDeLivros")
	public Page<LivroDto> lista(@PageableDefault(sort="id",direction = Direction.ASC,page=0,size=10) Pageable paginacao){		
			Page<Livro> livros = livroRepository.findAll(paginacao);	
			return LivroDto.toModel(livros);
	}

	
	@PostMapping
	@Transactional
	@CacheEvict(value="listaDeLivros",allEntries = true)
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm form) {
		
		Livro livro = form.toModel(form,autorRepository,categoriaRepository);	
		livroRepository.save(livro);	
		return ResponseEntity.ok().build();	
	}
	
}
