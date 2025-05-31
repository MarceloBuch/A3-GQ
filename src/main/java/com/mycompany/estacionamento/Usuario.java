
package com.mycompany.estacionamento;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String senhaUsuario;

    public Usuario(int id, String nome, String senhaUsuario) {
        this.idUsuario = id;
        this.nomeUsuario = nome;
        this.senhaUsuario = senhaUsuario;
    }
    
    public Usuario(String nome, String senhaUsuario) {
        this.nomeUsuario = nome;
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario(String nome) {
        this.nomeUsuario = nome;
    }

    public int getIdUsuario() { return idUsuario; }
    public String getNomeUsuario() { return nomeUsuario; }
    public String getSenhaUsuario() { return senhaUsuario; }
}
