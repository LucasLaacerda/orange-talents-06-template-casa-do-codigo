package br.com.zupacademy.lucaslacerda.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.zupacademy.lucaslacerda.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.lucaslacerda.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.lucaslacerda.casadocodigo.model.Autor;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private final AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form) {
		
		Autor autor = form.toModel(form);	
		autorRepository.save(autor);	
		return ResponseEntity.ok(new AutorDto(autor));	
	}
	
	
	
}
