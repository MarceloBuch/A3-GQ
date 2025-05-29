package com.mycompany.estacionamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO {

    public void inserirMovimento(Movimento movimento) {
        String sql = "INSERT INTO movimento (placaVeiculo, dataEntrada, status) VALUES (?, NOW(), 1)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, movimento.getPlacaVeiculo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movimento> listarTodos() {
        List<Movimento> movimentos = new ArrayList<>();
        String sql = "SELECT * FROM movimento";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Movimento m = new Movimento(
                    rs.getInt("IdMovimento"),
                    rs.getString("placaVeiculo"),
                    rs.getTimestamp("dataEntrada").toLocalDateTime(),
                    rs.getTimestamp("dataSaida") != null ? rs.getTimestamp("dataSaida").toLocalDateTime() : null,
                    rs.getDouble("valorPago"),
                    rs.getString("status")
                );
                movimentos.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movimentos;
    }
    
    public List<Movimento> listarEmAberto() {
        List<Movimento> movimentos = new ArrayList<>();
        String sql = "SELECT * FROM movimento WHERE status = 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Movimento m = new Movimento(
                    rs.getInt("IdMovimento"),
                    rs.getString("placaVeiculo"),
                    rs.getTimestamp("dataEntrada").toLocalDateTime(),
                    rs.getTimestamp("dataSaida") != null ? rs.getTimestamp("dataSaida").toLocalDateTime() : null,
                    rs.getDouble("valorPago"),
                    rs.getString("status")
                );
                movimentos.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movimentos;
    }

    public void atualizarMovimento(Double valor, int IdMovimento) {
        String sql = "UPDATE movimento SET dataSaida = NOW(), valorPago = ?, status = 9 WHERE IdMovimento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, valor);
            stmt.setInt(2, IdMovimento);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarMovimento(int idMovimento) {
        String sql = "UPDATE movimento SET status = 9 WHERE IdMovimento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMovimento);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

