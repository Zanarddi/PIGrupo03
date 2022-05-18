package componentesGUILogin;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Frame inicial do programa.
 * É nela que são mostradas as telas relacionadas ao login.
 * Implementa um CardLayout
 * 
 * @author Gustavo Zanardi
 *
 */
public class FrameInicial extends JFrame {

	static JPanel painelPai;

	// declaração das telas
	public static TelaLogin telaLogin;
	private TelaRegistro telaRegistrar;
	private TelaRecSenha telaRecSenha;

	public FrameInicial() {
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); // valores não "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		painelPai = new JPanel();
		painelPai.setLayout(new CardLayout());
		getContentPane().add(painelPai);

		telaLogin = new TelaLogin();
		telaRegistrar = new TelaRegistro();
		telaRecSenha = new TelaRecSenha();

		painelPai.add(telaLogin, "Login");
		painelPai.add(telaRegistrar, "Registrar");
		painelPai.add(telaRecSenha, "Recuperar");
	}
}
