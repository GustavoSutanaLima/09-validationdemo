# ```messages.properties``` (Spring MVC e Validation)

* O arquivo ```messages.properties``` no Spring MVC é usado para armazenar mensagens de texto que serão exibidas na interface do usuário. Ele é especialmente útil para internacionalização (i18n), pois permite definir mensagens em diferentes idiomas e alternar entre eles facilmente.

    ```properties

    Copiar
    # Mensagens para campos obrigatórios
    field.required=Este campo é obrigatório.

    # Mensagens de validação
    validation.age=Por favor, insira uma idade válida.
    validation.email=Por favor, insira um email válido.

    # Mensagens de sucesso
    success.registration=Registro concluído com sucesso.

* Para criar suporte em outro idioma, como inglês, basta criar um arquivo ```messages_en.properties```:

    
    ```properties
    # Required field messages
    field.required=This field is required.

    # Validation messages
    validation.age=Please enter a valid age.
    validation.email=Please enter a valid email.

    # Success messages
    success.registration=Registration completed successfully.
    ```
* O Spring MVC automaticamente seleciona o arquivo de mensagens apropriado com base nas configurações de localidade do usuário. Assim, sua aplicação pode fornecer feedback amigável e compreensível em vários idiomas.