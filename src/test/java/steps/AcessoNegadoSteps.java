package steps;

import com.mycompany.estacionamento.Login;
import io.cucumber.java.pt.*;
import static org.junit.Assert.*;

public class AcessoNegadoSteps {

    Login tela;

    @Dado("que o funcionário esteja na tela de login")
    public void que_o_funcionario_esteja_na_tela_de_login() {
        tela = new Login();
        tela.setVisible(true);
    }

    @Quando("ele informar usuário ou senha incorretos")
    public void ele_informar_usuario_ou_senha_incorretos() {
        tela.jTextField1.setText("usuarioInvalido");
        tela.jPasswordField1.setText("senhaErrada");
    }

    @E("clicar no botão de \"Entrar\" no sistema")
    public void clicar_no_botao_de_entrar_no_sistema() {
        tela.jButton1.doClick();
    }

    @Entao("o sistema deve exibir uma mensagem de erro e negar o acesso")
    public void o_sistema_deve_exibir_uma_mensagem_de_erro_e_negar_o_acesso() {
        String mensagem = tela.getMessage();
        assertEquals("Usuário ou senha inválidos", mensagem);
    }
}
