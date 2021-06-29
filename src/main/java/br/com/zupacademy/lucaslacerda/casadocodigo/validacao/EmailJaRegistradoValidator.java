package br.com.zupacademy.lucaslacerda.casadocodigo.validacao;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zupacademy.lucaslacerda.casadocodigo.model.Autor;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.AutorRepository;

public class EmailJaRegistradoValidator implements ConstraintValidator<EmailJaRegistradoValid, String> {

	
	 private String value;
	 
	 @Autowired
	 AutorRepository autorRepository;
	
	@Override
	 public void initialize(EmailJaRegistradoValid constraintAnnotation) {
	      this.value = constraintAnnotation.value();
	 }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<Autor> usuario = autorRepository.findByEmail(value);
		if(usuario.isPresent()) {
			return false;
		}
		return true;
	}

}
