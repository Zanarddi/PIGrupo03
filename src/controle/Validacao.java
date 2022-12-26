package controle;

import javax.swing.JOptionPane;

/**
 * Classe com m�todos de valida��o de dados.
 * 
 * @author Gustavo Zanardi
 *
 */
public class Validacao {

	/**
	 * verifica se um valor � inteiro
	 * @param n
	 * @return
	 */
	public static boolean verificaInt(String n) {
		boolean ret;
		try {
		Integer.parseInt(n);
		ret = true;
		}
		catch (Exception e){
			ret = false;
		}
		return ret;
	}

	/**
	 * verifica se uma string cont�m espa�os vazios
	 * @param s - string a ser analizada
	 * @return - true para espa�o vazio e false para n�o
	 */
	public static boolean verificaEspacoVazio(String s) {
		boolean ret = false;
		for (char c : s.toCharArray()) {
		    if (Character.isWhitespace(c)) {
		       ret = true;
		    }
		}
		return ret;
	}
	
	/**
	 * Faz a valida��o dos campos da tela de cadastro de novos usu�rios
	 * @param email
	 * @param usuario
	 * @param senha
	 * @param senhaRep
	 * @return
	 */
	public static boolean validaCamposRegistro(String email, String usuario, String senha, String senhaRep) {
		boolean ret = false;
		if(email.isEmpty() || usuario.isEmpty() || senha.isEmpty() || senhaRep.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
			ret = false;
		}
		else if (verificaEspacoVazio(email) || verificaEspacoVazio(usuario) ||verificaEspacoVazio(senha) ||verificaEspacoVazio(senhaRep)) {
			JOptionPane.showMessageDialog(null, "N�o s�o permitidos espa�os vazios");
			ret = false;
		}
		else if (!senha.equals(senhaRep)) {
			JOptionPane.showMessageDialog(null, "As senhas devem ser iguais");
			ret = false;
		}
		else {
			ret = true;
		}
		return ret;
	}
}
