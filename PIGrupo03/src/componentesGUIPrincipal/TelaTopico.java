package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentesGUILogin.Config;

/**
 * GUI onde são mostrados os tópicos a serem estudados.
 * Essa tela nunca é utilizada sozinha, mas sim em um cardlayout da tela de estudos.
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaTopico extends TelaPadrao {

	static BotaoPadrao btProximo = new BotaoPadrao("Próximo", 0, 0, 150, 50, 24);
	static BotaoPadrao btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);

	JPanel painelExplicacao;
	
	LabelPadrao lbTitulo;
	LabelPadrao lbTema;
	LabelPadrao lbExplicacao;
	
	
	public TelaTopico(String titulo, String tema, String explicacao) {
		
		painelExplicacao = new JPanel();
		
		lbTitulo = new LabelPadrao(titulo, 36, Color.WHITE);
		lbTitulo.setFont(new Font(Config.FONTE, Font.BOLD, 36));
		
		lbTema = new LabelPadrao(tema, 18, Color.WHITE);
		lbExplicacao = new LabelPadrao(explicacao, 24, Color.WHITE);
		
		painelExplicacao.setLayout(new BoxLayout(painelExplicacao, BoxLayout.Y_AXIS));
		painelExplicacao.setBackground(this.getBackground());
		painelExplicacao.setBorder(new EmptyBorder(0, 50, 0, 0));
		
		painelExplicacao.setBackground(componentesGUILogin.Config.COR_FONTE_BOTAO);
		
		painelExplicacao.add(Box.createVerticalStrut(50));
		painelExplicacao.add(lbTitulo);
		painelExplicacao.add(lbTema);
		painelExplicacao.add(lbExplicacao);
		
		this.add(Box.createVerticalStrut(50));
		this.add(painelExplicacao);
		
		
		//add(new JLabel(titulo));
	}

	private void setListeners() {

	}

	private void setComponents() {
		
		this.buttonPanel.add(btProximo);
		this.buttonPanel.add(btVoltar);
		
	}

}
