package steps;

import static org.junit.Assert.*;

import java.awt.Robot;

import io.cucumber.java.pt.*;
import com.mycompany.estacionamento.CadastroClient;
import javax.swing.*;


public class CadastroClienteSteps {

    CadastroClient tela;

    @Dado("que o funcionário esteja na tela de cadastro de clientes")
    public void que_o_funcionario_esteja_na_tela_de_cadastro_de_clientes() {
        tela = new CadastroClient();
        tela.setVisible(true);
    }

    @Quando("ele preencher corretamente todos os campos do cadastro de cliente obrigatórios")
    public void ele_preencher_corretamente_todos_os_campos_do_cadastro_de_cliente_obrigatorios() {
        JTextField txtNome = tela.jTextField1;
        JTextField txtTelefone = tela.jTextField2;
        JTextField txtCpf = tela.jTextField3;

        txtNome.setText("Maria Teste");
        txtTelefone.setText("11999999999");
        txtCpf.setText("12345678901");
    }

    @Quando("clicar em {string}")
    public void clicar_em(String botao) {
        JButton btnSalvar = tela.jButton1;
        btnSalvar.doClick();
    }

    @Entao("o sistema deve cadastrar o cliente e exibir uma mensagem de sucesso")
    public void o_sistema_deve_cadastrar_o_cliente_e_exibir_uma_mensagem_de_sucesso() {
        assertEquals("Cliente cadastrado com sucesso", tela.getMensagem());
    }
}
