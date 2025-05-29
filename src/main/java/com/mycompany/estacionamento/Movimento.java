package com.mycompany.estacionamento;

import java.time.LocalDateTime;

public class Movimento {
    private int idMovimento;
    private String placaVeiculo;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private double valorPago;
    private String status;

    public Movimento(int idMovimento, String placaVeiculo, LocalDateTime dataEntrada, LocalDateTime dataSaida, double valorPago, String status) {
        this.idMovimento = idMovimento;
        this.placaVeiculo = placaVeiculo;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorPago = valorPago;
        this.status = status;
    }
    
    public Movimento(int idMovimento, String placaVeiculo, LocalDateTime dataEntrada) {
        this.idMovimento = idMovimento;
        this.placaVeiculo = placaVeiculo;
        this.dataEntrada = dataEntrada;
    }
    
    public Movimento(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getStatus() {
        return status;
    }
}

