package controle;

public class Controles {
	
	/**
	 * método que valida o login do usuário
	 * @param usuario - nome do usuario
	 * @param senha - senha do usuario
	 * @return - true para login validado
	 */
	public static boolean validarLogin(String usuario, String senha) {
		return true;
	}
	
	/**
	 * método que verifica se o usuário é um administrador
	 * @param usuario - nome do usuario
	 * @param senha - senha do usuario
	 * @return - true para usuario administrador
	 */
	public static boolean validaAdministrador(String usuario, String senha) {
		return false;
	}

}
