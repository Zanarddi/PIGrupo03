package controle;

import componentesGUILogin.TelaInicial;
import componentesGUIPrincipal.TelaPrincipal;
import modelo.Login;

public class Main {

	// duas principais frames do projeto
	static TelaInicial telaInicial;
	public static TelaPrincipal telaPrincipal;
	
	public static Login login;
	public static int limiteTopicosEstudo;

	public static void main(String[] args) {
		iniciarFrameLogin();
	}
	
	/**
	 * Método que inicia a frame de login (inicial), e fecha a tela principal caso
	 * ela esteja aberta
	 */
	public static void iniciarFrameLogin() {
		telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
		if (telaPrincipal != null)
			telaPrincipal.dispose();
	}

	/**
	 * Método que inicia a frame principal e fecha a tela de login caso ela esteja
	 * aberta
	 * @param usuario - usuario validado
	 * @param senha - senha validada
	 */
	public static void iniciarFramePrincipal() {
		telaPrincipal = new TelaPrincipal(login);
		telaPrincipal.setVisible(true);
		System.out.println(telaPrincipal.getComponentCount());
		if (telaInicial != null)
			telaInicial.dispose();
	}
}
