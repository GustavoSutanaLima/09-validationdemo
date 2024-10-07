package edu.gustavodev.springdemo.mvc.validationdemo.validation;

import jakarta.validation.Constraint; 
import jakarta.validation.Payload; 

import java.lang.annotation.Target; 
import java.lang.annotation.ElementType; 
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = CourseCodeConstrainValidator.class) // Especifica a classe que implementa a lógica de validação da anotação @CourseCode
@Target({ElementType.METHOD, ElementType.FIELD}) // Define que a anotação @CourseCode pode ser aplicada tanto a métodos quanto a atributos (fields)
@Retention(RetentionPolicy.RUNTIME) // Indica que a anotação @CourseCode deve estar disponível em tempo de execução
public @interface CourseCode {

    // Define um valor padrão para o código do curso, que será usado se nenhum outro valor for especificado
    public String value() default "GUST";

    // Define uma mensagem de erro padrão a ser exibida se a validação falhar
    public String message() default "Deve começar com GUST";

    // Permite a especificação de grupos de validação, uma funcionalidade avançada para organizar diferentes tipos de validação
    public Class<?>[] groups() default {};

    // Permite a adição de informações personalizadas às restrições de validação, frequentemente utilizadas por frameworks de validação
    public Class<? extends Payload>[] payload() default {};
}
