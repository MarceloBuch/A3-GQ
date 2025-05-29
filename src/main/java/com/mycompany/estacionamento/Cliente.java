package com.mycompany.estacionamento;

public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String telefoneCliente;
    private String cpfCnpjCliente;
    private String status;

    public Cliente(int idCliente, String nomeCliente, String telefoneCliente, String cpfCnpjCliente, String status) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.status = status;
    }
    public Cliente(int idCliente, String nomeCliente, String telefoneCliente, String cpfCnpjCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.cpfCnpjCliente = cpfCnpjCliente;
    }
    
    public Cliente(String nomeCliente, String telefoneCliente, String cpfCnpjCliente) {
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public String getStatus() {
        return status;
    }
}
