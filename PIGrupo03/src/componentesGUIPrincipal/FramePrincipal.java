package componentesGUIPrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import modelo.Login;

/**
 * Frame principal do programa, onde são mostradas as diversas funcionalidades
 * do sistema
 * 
 * @author Gustavo Zanardi
 *
 */
public class FramePrincipal extends JFrame {

	public static PainelBotoes painelBotoes;
	public static TelaBemVindo telaBemVindo;
	public static JPanel painelPrincipal;

	public FramePrincipal(Login l) {

		// configurações da JFrame
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); // valores não "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		painelBotoes = new PainelBotoes();
		add(painelBotoes, BorderLayout.WEST);
		painelBotoes.setVisible(true);

		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new CardLayout());
		add(painelPrincipal);

		telaBemVindo = new TelaBemVindo();
		if(l.getTipo() == 0)
		painelPrincipal.add(telaBemVindo, "telaBemVindo");
		
		// adiciona os paineis correspondentes dos botoes ao cardlayout
		for (BotaoPadraoPainel botao : PainelBotoes.botoes) {
			painelPrincipal.add(botao.painel, botao.texto);
		}
	}
}
