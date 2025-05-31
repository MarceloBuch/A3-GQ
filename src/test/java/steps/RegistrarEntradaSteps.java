package steps;

import com.mycompany.estacionamento.RegistroEntradaVeiculo;
import io.cucumber.java.pt.*;
import static org.junit.Assert.*;

public class RegistrarEntradaSteps {

	RegistroEntradaVeiculo tela;

    @Dado("que o usuario esteja na tela de registro de entradas")
    public void que_o_usuario_esteja_na_tela_de_registro_de_entradas() {
        tela = new RegistroEntradaVeiculo();
        tela.setVisible(true);
    }

    @Quando("o funcionário selecionar a placa do veículo e confirmar a entrada")
    public void o_funcionario_selecionar_a_placa_do_veiculo_e_confirmar_a_entrada() {
        tela.jTextField1.setText("999999");
        tela.jButton1.doClick();
    }

    @Entao("o sistema deve registrar a entrada e informar mensagem de sucesso")
    public void o_sistema_deve_registrar_a_entrada_e_informar_mensagem_de_sucesso() {
        String mensagem = tela.getMessage();
        assertEquals("Entrada confirmada!", mensagem);
    }
}
