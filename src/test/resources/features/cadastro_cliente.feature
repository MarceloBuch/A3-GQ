@cadastroCliente
Feature: Cadastro de Clientes

  Scenario: Cadastro de novo cliente
    Given que o funcionário esteja na tela de cadastro de clientes
		When ele preencher corretamente todos os campos do cadastro de cliente obrigatórios
    And clicar em "Salvar" 
    Then o sistema deve cadastrar o cliente e exibir uma mensagem de sucesso
