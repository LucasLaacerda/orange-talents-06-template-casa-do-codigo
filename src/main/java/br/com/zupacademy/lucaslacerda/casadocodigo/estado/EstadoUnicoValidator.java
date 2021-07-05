package br.com.zupacademy.lucaslacerda.casadocodigo.estado;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.lucaslacerda.casadocodigo.pais.Pais;
import br.com.zupacademy.lucaslacerda.casadocodigo.pais.PaisRepository;

@Component
public class EstadoUnicoValidator implements Validator {
	
	@PersistenceContext
	EntityManager em;
	@Autowired
	PaisRepository paisRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {	
		return EstadoForm.class.equals(clazz);	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//Ele nao retorna erro da annotation ValidationId sem essa verificacao
		if (errors.hasErrors()) {
		    return;
		 }
		  
		EstadoForm estado = (EstadoForm) target;
		analisaEstado(estado, errors);		
	}
	
	
	public void analisaEstado(@Valid EstadoForm estado, Errors errors) {
		
		 Query query = em.createQuery("select t from Estado t where t.nome = :pEstado and t.pais = :pPais");
		 query.setParameter("pEstado", estado.getNome());
	     query.setParameter("pPais", paisRepository.findById(estado.getPais()).get());
	     
	     if(query.getResultList().size()>0) errors.rejectValue("Pais", null, "Estado ja cadastrado para esse Pais");
	}

	
	
}
