package crud;

import modelo.Login;

public class UsaLogin {

	/**
	 * método que valida o login do usuário
	 * @param usuario - nome do usuario
	 * @param senha - senha do usuario
	 * @return - true para login validado
	 */
	public static boolean validarLogin(String usuario, String senha) {
		//falta adicionar o metodo no crud que valida o login, usando duas strings
		return true;
	}
	
	/**
	 * Buscar o limite de estudo diario do usuário
	 * @param l - objeto login
	 * @return - int com o limite de topicos
	 */
	public static int buscaLimiteEstudo(Login l) {
		//tem que implementar para fazer a pesquisa no banco e encontrar esse valor
		return 10;
	}
}
