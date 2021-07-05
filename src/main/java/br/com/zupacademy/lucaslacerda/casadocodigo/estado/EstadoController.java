package br.com.zupacademy.lucaslacerda.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	EstadoUnicoValidator estadoUnicoValidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(estadoUnicoValidator);
	}


	public EstadoController(EntityManager manager, EstadoUnicoValidator estadoUnicoValidator){
		super();
		this.manager = manager;
		this.estadoUnicoValidator = estadoUnicoValidator;
	}



	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Validated EstadoForm form) {
		
		Estado estado = form.toModel(form,manager);	
		manager.persist(estado);	
		return ResponseEntity.ok().build();	
	}
}
