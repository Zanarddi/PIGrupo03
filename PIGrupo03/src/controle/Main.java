package controle;

import componentesGUILogin.FrameInicial;
import componentesGUIPrincipal.FramePrincipal;
import modelo.Login;

/**
 * Classe Main, onde é iniciado o programa
 * 
 * @author Gustavo Zanardi
 *
 */
public class Main {

	// duas principais frames do projeto
	public static FrameInicial frameInicial;
	public static FramePrincipal framePrincipal;
	
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
		frameInicial = new FrameInicial();
		frameInicial.setVisible(true);
		if (framePrincipal != null)
			framePrincipal.dispose();
	}

	/**
	 * Método que inicia a frame principal e fecha a tela de login caso ela esteja
	 * aberta
	 * @param usuario - usuario validado
	 * @param senha - senha validada
	 */
	public static void iniciarFramePrincipal() {
		framePrincipal = new FramePrincipal(login);
		framePrincipal.setVisible(true);
		if (frameInicial != null)
			frameInicial.dispose();
	}
}
