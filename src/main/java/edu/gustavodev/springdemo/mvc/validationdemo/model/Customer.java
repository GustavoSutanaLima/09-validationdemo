package edu.gustavodev.springdemo.mvc.validationdemo.model;

import edu.gustavodev.springdemo.mvc.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
    /*Atributos de classe (ou fields)*/
    private String firstName;

    @NotNull(message = "Este campo é obrigatório!") /*Anotação do Bean Validation API, que diz que esse campo NÃO pode ser nulo em uma aplicação Spring MVC */
    @Size(min = 1, message = "Este campo é obrigatório!") /*Outra anotação do Bean Validation API, essa dita que o tamanho mínimo do campo deve ser 1 */
                                             /*Nesse caso, como o atributo abaixo é uma String, o campo tem que ter pelo menos 1 caracter */
    private String lastName;

    @NotNull(message = "Um usuário precisa cadastra sua idade.")
    @Min(value = 18, message = "A idade mínima é 18.")
    @Max(value = 100, message = "Digite uma idade válida!")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9-,.]{10}", message = "Um CEP precisa ter 10 caracteres válidos!")
    /*A anotação @Pattern só pode ser usada com strings. */
    private String postalCode;

    @CourseCode(value = "GUS", message = "O código do curso precisa inicar em: GUS")
    private String courseCode;

    /* Construtor vazio */
    public Customer () {
        
    }
    
    /*Getters e Setters: SÃO EXTREMAMENTE IMPORTANTES POIS O SPRING MVC USA ESSES MÉTODOS PARA PODER TRABALHAR OS DADOS
    * DO MODELO, OU SEJA, LEVAR E EXTRAR AS INFORMAÇÕES DA VIEW PAGE, POR EXEMPLO.
    */
    
    public String getFirstName() {
        return firstName;
    }
    
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /*toString() */
    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
    }


}
