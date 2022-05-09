package crud;

import modelo.Login;

public class LoginDAO {
	
	/**
	 * método que valida o login do usuário
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
	 * Buscar o limite de estudo diario do usuário
	 * 
	 * @param l - objeto login
	 * @return - int com o limite de topicos
	 */
	public static int buscaLimiteEstudo(Login l) {
		// tem que implementar para fazer a pesquisa no banco e encontrar esse valor
		return 10;
	}
	
	/**
	 * método que verifica se o usuário é um administrador
	 * @param usuario - nome do usuario
	 * @param senha - senha do usuario
	 * @return - true para usuario administrador
	 */
	public static boolean validaAdministrador(Login l) {
		return false;
	}

}
