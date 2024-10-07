# Processando dandos antes de serem passados ao modelo Spring MVC

A anotação ```@InitBinder``` no Spring Boot é usada para personalizar o binding de parâmetros de request para objetos do modelo em seus controladores. Pode ser útil, por exemplo, para registrar <u>validadores customizados, converters ou para pré-processar dados antes de serem atribuídos ao modelo</u>.

Por exemplo, se você tem um objeto ```User``` e quer garantir que todos os campos em branco sejam convertidos para ```null```. Você pode criar um método com a anotação ```@InitBinder```:

```java
@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
}
```
