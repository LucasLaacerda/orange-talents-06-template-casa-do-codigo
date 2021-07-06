package br.com.zupacademy.lucaslacerda.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

import br.com.zupacademy.lucaslacerda.casadocodigo.estado.EstadoObrigatorioValidator;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	EstadoObrigatorioValidator estadoObrigatorioValidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(estadoObrigatorioValidator);
	}


	public ClienteController(EntityManager manager, EstadoObrigatorioValidator estadoObrigatorioValidator){
		super();
		this.manager = manager;
		this.estadoObrigatorioValidator = estadoObrigatorioValidator;
	}



	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Validated ClienteForm form) throws Throwable {
		
		Cliente cliente = form.toModel(manager);	
		manager.persist(cliente);	
		return ResponseEntity.ok().build();	
	}
	
}
