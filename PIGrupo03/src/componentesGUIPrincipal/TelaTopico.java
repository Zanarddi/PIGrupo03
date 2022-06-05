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
		
		painelExplicacao.add(Box.createVerticalStrut(30));
		painelExplicacao.add(lbTitulo);
		painelExplicacao.add(lbTema);
		painelExplicacao.add(Box.createVerticalStrut(10));
		painelExplicacao.add(lbExplicacao);
		
		this.add(Box.createVerticalStrut(50));
		this.add(painelExplicacao);
	}
}
