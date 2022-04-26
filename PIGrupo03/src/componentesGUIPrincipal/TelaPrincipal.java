package componentesGUIPrincipal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TelaPrincipal extends JFrame {

	private static String usuario;
	private static String senha;
	
	PainelBotoes painelBotoes = new PainelBotoes();
	
	public TelaPrincipal(String usuario, String senha) {
		
		setUsuario(usuario);
		setSenha(senha);
		
		//configurações da JFrame
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); // valores não "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		add(painelBotoes, BorderLayout.WEST);
		painelBotoes.setVisible(true);
		
	}

	public static String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
