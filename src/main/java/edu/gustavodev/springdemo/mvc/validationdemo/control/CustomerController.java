package edu.gustavodev.springdemo.mvc.validationdemo.control;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.gustavodev.springdemo.mvc.validationdemo.model.Customer;
import jakarta.validation.Valid;

@Controller
public class CustomerController {

    /*  O método anotado com @InitBinder é chamado antes dos métodos do controlador serem executados */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
    
    /*  Cria um StringTrimmerEditor (uma classe do Spring API), que remove espaços em branco das strings. 
        O parâmetro 'true' indica que strings vazias (ou seja, somente com espaços) devem ser convertidas para null */
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

    /*  Registra o editor customizado para o tipo String, aplicando o StringTrimmerEditor 
        a todas as strings no modelo de dados. Ou seja, qualquer String que for "trazida" para dentro do 
        controlador será, primeiramente, processada por este método */
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    
}


    @GetMapping("/")
    public String showForm(Model model) {
        /* Model é uma interface que permite os dados serem trafegados entre as camadas
         * de Controle (Controller) e a Visualização (View) do Spring MVC;
         */
        /*
         * addAttribute passa o objeto (nesse caso um novo objeto da classe Customer)
         * customer_name é como esse objeto será interpretado no arquivo html;
         */
        model.addAttribute("customer_name", new Customer());

        /*
         * Carrega a view page que está escrita no arquivo "customer-form.html"
         */
        return "customer-form";
    }

    @PostMapping("/processedCustomer")
    public String processForm(@Valid @ModelAttribute("customer_name") Customer customer, BindingResult bidingResult){
        /* @Valid diz para o spring mvc fazer a validação de acordo com o objeto, nesse caso, um do tipo Customer */
        /* BidingResult tem todos os dados de validação, por exemplo, se houverem errors, por exemplo, esse classe
         * tem essas informações. Lembrando que as anotações que fazem as validações são usadas na classe principal, 
         * ou seja, Customer.
         */
        System.out.println("Verificando os biding results: ");
        System.out.println(bidingResult.toString());
        System.out.println("_____");

        if (bidingResult.hasErrors()) {
            /* A classe BindingResult do Spring MVC permite verificar há erros de validação, que é frequentemente 
             * usada em conjunto com Jakarta Bean Validation para validar objetos de formulário. 
             */
            return "customer-form";
        }
        else {

            return "processed-customer";
        }
        
    }

}
