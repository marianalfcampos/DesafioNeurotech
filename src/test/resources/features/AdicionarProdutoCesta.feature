# Descrição dos cenárioa de teste para a funcinalidade 'Adicionar produto a cesta'
Feature: Adicionar produto na cesta

  Scenario: Como usuario, para comprar um determinado produto,
    eu quero adiciona-lo a minha cesta

    Given O usuario esta na pagina inicial
    When O usuario pesquisa o produto "ps4"
    And Seleciona o produto "Console"
    And Preenche o cep "50610220"
    And Clica em comprar
    And Seleciona garantia "+ 12 meses"
    And Clica em continuar
    Then O produto deve estar na cesta
