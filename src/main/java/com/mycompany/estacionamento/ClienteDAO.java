package com.mycompany.estacionamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nomeCliente, telefoneCliente, cpf_cpnjCliente, status) VALUES (?, ?, ?, 1)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getTelefoneCliente());
            stmt.setString(3, cliente.getCpfCnpjCliente());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarCliente() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente where status = 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nomeCliente"),
                    rs.getString("telefoneCliente"),
                    rs.getString("cpf_cpnjCliente"),
                    rs.getString("status")
                );
                clientes.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nomeCliente = ?, telefoneCliente = ?, cpf_cpnjCliente = ? WHERE idCliente = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getTelefoneCliente());
            stmt.setString(3, cliente.getCpfCnpjCliente());
            stmt.setInt(4, cliente.getIdCliente());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarCliente(int idCliente) {
        String sql = "UPDATE cliente SET status = 9 WHERE idCliente = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

