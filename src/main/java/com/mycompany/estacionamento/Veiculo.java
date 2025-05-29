
package com.mycompany.estacionamento;

public class Veiculo {
    private String placaVeiculo;
    private String modeloVeiculo;
    private String corVeiculo;
    private int clienteVeiculo; 
    private String status;

    public Veiculo(String placaVeiculo, String modeloVeiculo, String corVeiculo, int clienteVeiculo) {
        this.placaVeiculo = placaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.corVeiculo = corVeiculo;
        this.clienteVeiculo = clienteVeiculo;
    }
    
    public Veiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public int getClienteVeiculo() {
        return clienteVeiculo;
    }
    
    public String getStatusVeiculo() {
        return status;
    }
}
