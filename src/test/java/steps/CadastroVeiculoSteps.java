package steps;

import static org.junit.Assert.assertEquals;

import com.mycompany.estacionamento.CadastroVeiculo;

import io.cucumber.java.pt.*;

public class CadastroVeiculoSteps {

	CadastroVeiculo tela;
    boolean veiculoSalvo;

    @Dado("que o funcionário esteja na tela de cadastro de veículos")
    public void que_o_funcionario_esteja_na_tela_de_cadastro_de_veiculos() {
        tela = new CadastroVeiculo();
        tela.setVisible(true);
    }

    @Quando("ele preencher corretamente todos os campos e vincular a um cliente")
    public void ele_preencher_corretamente_todos_os_campos_e_vincular_um_cliente() {
        tela.jTextField1.setText("999993"); 
        tela.jTextField2.setText("Fiat Uno"); 
        tela.jTextField3.setText("Prata");    
        int linhaFicticia = 0;
        tela.jTable2.setRowSelectionInterval(linhaFicticia, linhaFicticia);
        tela.jTable2.setValueAt(1, linhaFicticia, 0); 
    }

    @E("clicar no botão \"Salvar\" do cadastro de veículo")
    public void clicar_no_botao_salvar_do_cadastro_de_veiculo() {
        tela.jButton1.doClick();
    }

    @Entao("o sistema deve cadastrar o veiculo e exibir uma mensagem de sucesso")
    public void o_sistema_deve_cadastrar_o_veiculo_e_exibir_uma_mensagem_de_sucesso() {
        String msg = tela.getMessage();
    	assertEquals("Veículo cadastrado com sucesso", msg);
    }
}
