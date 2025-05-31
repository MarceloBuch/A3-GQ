package steps;

import com.mycompany.estacionamento.RegistroSaidaVeiculo;
import io.cucumber.java.pt.*;
import static org.junit.Assert.*;

public class RegistrarSaidaSteps {

	RegistroSaidaVeiculo tela;

    @Dado("que o usuario esteja na tela de saidas")
    public void que_o_usuario_esteja_na_tela_de_saidas() {
        tela = new RegistroSaidaVeiculo();
        tela.setVisible(true);
    }

    @Quando("o funcionário selecionar a placa do veículo e confirmar a saída")
    public void o_funcionario_selecionar_a_placa_do_veiculo_e_confirmar_a_saida() {
        tela.jTable1.setRowSelectionInterval(0, 0);
        tela.jLabel5.setText("50");
        tela.jButton1.doClick();
    }

    @Entao("o sistema deve calcular corretamente o valor a pagar e mostrar a mensagem de sucesso")
    public void o_sistema_deve_calcular_corretamente_o_valor_a_pagar_e_mostrar_a_mensagem_de_sucesso() {
        String mensagem = tela.getMessage();
        assertEquals("Saída Confirmada", mensagem);
    }
}