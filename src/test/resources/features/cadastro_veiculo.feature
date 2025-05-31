@cadastroVeiculo
Feature: Cadastro de Veículos

  Scenario: Cadastro de novo veículo
    Given que o funcionário esteja na tela de cadastro de veículos
    When ele preencher corretamente todos os campos e vincular a um cliente
    And clicar no botão "Salvar" do cadastro de veículo 
    Then o sistema deve cadastrar o veiculo e exibir uma mensagem de sucesso