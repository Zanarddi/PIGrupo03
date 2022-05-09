package componentesGUIPrincipal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import modelo.Login;

/**
 * Frame principal do programa, onde são mostradas as diversas funcionalidades
 * do sistema
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaPrincipal extends JFrame {

	PainelBotoes painelBotoes = new PainelBotoes();

	public TelaPrincipal(Login l) {

		// configurações da JFrame
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); // valores não "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		add(painelBotoes, BorderLayout.WEST);
		painelBotoes.setVisible(true);

	}
}
