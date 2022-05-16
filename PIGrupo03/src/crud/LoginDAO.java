package crud;

import modelo.Login;

public class LoginDAO {

	/**
	 * m�todo que valida o login do usu�rio
	 * 
	 * @param usuario - nome do usuario
	 * @param senha   - senha do usuario
	 * @return - true para login validado
	 */
	public static boolean validarLogin(String usuario, String senha) {
		// falta adicionar o metodo no crud que valida o login, usando duas strings
		return true;
	}

	/**
	 * Buscar o limite de estudo diario do usu�rio
	 * 
	 * @param usuario
	 * @return - numero limite de estudo
	 */
	public static int buscaLimiteEstudo(String usuario) {
		// tem que implementar para fazer a pesquisa no banco e encontrar esse valor
		return 10;
	}

	/**
	 * Buscar o limite de revisoes diarias do usu�rio
	 * 
	 * @param usuario
	 * @return - numero limite de revisoes
	 */
	public static int buscaLimiteRevisao(String usuario) {
		// tem que implementar para fazer a pesquisa no banco e encontrar esse valor
		return 11;
	}

	/**
	 * m�todo que verifica se o usu�rio � um administrador
	 * 
	 * @param usuario - nome do usuario
	 * @param senha   - senha do usuario
	 * @return - true para usuario administrador
	 */
	public static boolean validaAdministrador(Login l) {
		return false;
	}

}
