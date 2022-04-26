package controle;

public class Controles {
	
	/**
	 * m�todo que valida o login do usu�rio
	 * @param usuario - nome do usuario
	 * @param senha - senha do usuario
	 * @return - true para login validado
	 */
	public static boolean validarLogin(String usuario, String senha) {
		return true;
	}
	
	/**
	 * m�todo que verifica se o usu�rio � um administrador
	 * @param usuario - nome do usuario
	 * @param senha - senha do usuario
	 * @return - true para usuario administrador
	 */
	public static boolean validaAdministrador(String usuario, String senha) {
		return false;
	}

}
