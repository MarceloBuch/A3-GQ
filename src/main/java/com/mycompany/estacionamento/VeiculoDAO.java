package com.mycompany.estacionamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public void inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placaVeiculo, modeloVeiculo, corVeiculo, clienteVeiculo, status) VALUES (?, ?, ?, ?, 1)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlacaVeiculo());
            stmt.setString(2, veiculo.getModeloVeiculo());
            stmt.setString(3, veiculo.getCorVeiculo());
            stmt.setInt(4, veiculo.getClienteVeiculo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> listarVeiculo() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo where status = 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Veiculo v = new Veiculo(
                    rs.getString("placaVeiculo"),
                    rs.getString("modeloVeiculo"),
                    rs.getString("corVeiculo"),
                    rs.getInt("clienteVeiculo")
                );
                veiculos.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return veiculos;
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET modeloVeiculo = ?, corVeiculo = ?, clienteVeiculo = ? WHERE placaVeiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getModeloVeiculo());
            stmt.setString(2, veiculo.getCorVeiculo());
            stmt.setInt(3, veiculo.getClienteVeiculo());
            stmt.setString(4, veiculo.getPlacaVeiculo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarVeiculo(String placaVeiculo) {
        String sql = "UPDATE veiculo SET status = 9 WHERE placaVeiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placaVeiculo);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean verificarExistencia(String placa) {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT placaVeiculo FROM veiculo where status = 1 and placaVeiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo v = new Veiculo(
                    rs.getString("placaVeiculo")
                );
                veiculos.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(veiculos.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
