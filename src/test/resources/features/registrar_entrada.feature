@RegistrarEntrada
Feature: Entrada de Veículo

Scenario: Registrar entrada de veículo
Given que o usuario esteja na tela de registro de entradas
When o funcionário selecionar a placa do veículo e confirmar a entrada
Then o sistema deve registrar a entrada e informar mensagem de sucesso