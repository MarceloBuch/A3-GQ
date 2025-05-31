@cadastroUsuario
Feature: Cadastro de Usuario

Scenario: Cadastro de novo usuário 
Given que o funcionário esteja na tela de cadastro de usuários
When ele preencher corretamente todos os campos do cadastro de usuário obrigatórios 
And clicar em "Salvar" do cadastro de usuário 
Then o sistema deve cadastrar o usuário e exibir uma mensagem de sucesso