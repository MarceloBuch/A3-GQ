@AcessoNegado
Feature: Login de Funcionário

  Scenario: Acesso negado
    Given que o funcionário esteja na tela de login
    When ele informar usuário ou senha incorretos
    And clicar no botão de "Entrar" no sistema
    Then o sistema deve exibir uma mensagem de erro e negar o acesso
