package br.com.zupacademy.lucaslacerda.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import br.com.zupacademy.lucaslacerda.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.lucaslacerda.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroRepository livroRepository;
	@PersistenceContext
	private EntityManager manager;
	
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
		
		Livro livro = form.toModel(manager);	
		livroRepository.save(livro);	
		return ResponseEntity.ok().build();	
	}
	
}
