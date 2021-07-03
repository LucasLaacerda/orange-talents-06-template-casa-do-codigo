package br.com.zupacademy.lucaslacerda.casadocodigo.detalhe;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lucaslacerda.casadocodigo.livro.Livro;

@RestController
@RequestMapping("/detalhe")
public class DetalheController {

	@PersistenceContext
	private EntityManager manager;
	
	
	@GetMapping("/livro/{id}")
	public ResponseEntity<DetalheLivro> detalhar(@PathVariable Long id) {
		
		if(manager.find(Livro.class, id)==null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(new DetalheLivro(manager.find(Livro.class, id)));	
		
	}
	
	
}
