package steps;

import com.mycompany.estacionamento.CadastroUsuario;
import io.cucumber.java.pt.*;
import static org.junit.Assert.*;

public class CadastroUsuarioSteps {

    CadastroUsuario tela;

    @Dado("que o funcionário esteja na tela de cadastro de usuários")
    public void que_o_funcionario_esteja_na_tela_de_cadastro_de_usuarios() {
        tela = new CadastroUsuario();
        tela.setVisible(true);
    }

    @Quando("ele preencher corretamente todos os campos do cadastro de usuário obrigatórios")
    public void ele_preencher_corretamente_todos_os_campos_do_cadastro_de_usuario_obrigatorios() {
        tela.jTextField1.setText("João da Silva");       
        tela.jTextField2.setText("senha123");           
        tela.jTextField3.setText("senha123");       
    }

    @E("clicar em \"Salvar\" do cadastro de usuário")
    public void clicar_em_salvar_do_cadastro_de_usuario() {
        tela.jButton1.doClick();
    }

    @Entao("o sistema deve cadastrar o usuário e exibir uma mensagem de sucesso")
    public void o_sistema_deve_cadastrar_o_usuario_e_exibir_uma_mensagem_de_sucesso() {
        String mensagem = tela.getMessage(); 
        assertEquals("Usuário inserido com sucesso", mensagem);
    }
}
