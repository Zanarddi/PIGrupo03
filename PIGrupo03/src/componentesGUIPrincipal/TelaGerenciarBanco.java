package componentesGUIPrincipal;

import javax.swing.border.EmptyBorder;

/**
 * Tela onde é feito o gerenciamento dos tópicos, perguntas e respostas do banco
 * de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaGerenciarBanco extends TelaPadrao {

	TelaManterTopico telaTopicos;

	public TelaGerenciarBanco() {
		painelCentro.setBorder(new EmptyBorder(20, 30, 0, 0));
		buttonPanel.setVisible(false);
		telaTopicos = new TelaManterTopico();
		painelCentro.add(telaTopicos);
	}
}
