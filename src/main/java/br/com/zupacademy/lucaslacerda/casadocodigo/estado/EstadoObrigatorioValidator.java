package br.com.zupacademy.lucaslacerda.casadocodigo.estado;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.lucaslacerda.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.lucaslacerda.casadocodigo.pais.Pais;
import br.com.zupacademy.lucaslacerda.casadocodigo.pais.PaisRepository;

@Component
public class EstadoObrigatorioValidator implements Validator {
	
	@PersistenceContext
	EntityManager em;
	@Autowired
	PaisRepository paisRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {	
		return ClienteForm.class.equals(clazz);	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//Ele nao retorna erro da annotation ValidationId sem essa verificacao
		if (errors.hasErrors()) {
		    return;
		 }
		  
		ClienteForm cliente = (ClienteForm) target;
		analisaEstado(cliente, errors);		
	}
	
	
	public void analisaEstado(@Valid ClienteForm cliente, Errors errors) {
		
		 Query query = em.createQuery("select t from Estado t where t.pais = :pPais");
	     query.setParameter("pPais", paisRepository.findById(cliente.getPais()).get());
	     
	     if(verificaResult(query.getResultList(),cliente)) 
	    	 errors.rejectValue("Estado", null, "Informe um estado");
	}

	private boolean verificaResult(List resultado,ClienteForm cliente) {
		if(resultado.size()>0 && cliente.getEstado()==null) 
			return true;
		else return false;
		
	}
	
}
