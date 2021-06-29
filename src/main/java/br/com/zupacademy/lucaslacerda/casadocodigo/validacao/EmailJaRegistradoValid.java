package br.com.zupacademy.lucaslacerda.casadocodigo.validacao;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailJaRegistradoValidator.class)
public @interface EmailJaRegistradoValid {
	
	String message() default "Email informado ja foi cadastrado"; 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; 
    String value() default "";
}
