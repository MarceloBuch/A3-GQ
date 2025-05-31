@RegistrarSaida
Feature: Saída de Veículo

Scenario: Registrar saída de veículo
Given que o usuario esteja na tela de saidas
When o funcionário selecionar a placa do veículo e confirmar a saída
Then o sistema deve calcular corretamente o valor a pagar e mostrar a mensagem de sucesso
