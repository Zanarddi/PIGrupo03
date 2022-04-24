package componentesGUI;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TelaInicial extends JFrame {

	static JPanel painelPai;

	// declaração das telas
	private TelaLogin telaLogin;
	private TelaRegistrar telaRegistrar;
	private TelaRecSenha telaRecSenha;

	public TelaInicial() {
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); 	// valores não "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); 	// faz a frame inicar no centro da tela
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		painelPai = new JPanel();
		painelPai.setLayout(new CardLayout());
		getContentPane().add(painelPai);

		telaLogin = new TelaLogin();
		telaRegistrar = new TelaRegistrar();
		telaRecSenha = new TelaRecSenha();

		painelPai.add(telaLogin, "Login");
		painelPai.add(telaRegistrar, "Registrar");
		painelPai.add(telaRecSenha, "Recuperar");
		

	}

	public static void main(String[] args) {

		TelaInicial telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
	}
}
