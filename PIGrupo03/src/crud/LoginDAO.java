package crud;

import java.sql.SQLException;

import modelo.Login;
import services.BD;

public class LoginDAO {

	private String sql, men;
	private BD bd;
	
	public LoginDAO() {
		bd = new BD();
	}
	
	/**
	 * método que exclui um usuário do banco de dados
	 * @param codigo - codigo do usuario a ser deletado
	 * @return - mensagem com resultado da operação
	 */
	public String excluir(int codigo) {
		sql = "delete usuario where cod_usuario = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			if (bd.st.executeUpdate() == 1)
				men = "Usuario excluído com sucesso!";
			else
				men = "Usuario não foi encontrado!";
		} catch (SQLException erro) {
			men = "Falha na exclusão " + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	

	/**
	 * método que tenta inserir um novo usuario no banco de dados, caso ele nao consiga inserir, ele edita o topico com o codigo inserido
	 * @param l
	 * @return
	 */
	public String salvar(Login l) {
		sql = "insert into usuario (cod_usuario, nome_usuario, senha_usuario, email_usuario, tipo_usuario, limite_estudo, limite_revisao, highscore_usuario) values (?,?,?,?,?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, l.getCodigo());
			bd.st.setString(2, l.getUsuario());
			bd.st.setString(3, l.getSenha());
			bd.st.setString(4, l.getEmail());
			bd.st.setInt(5, l.getTipo());
			bd.st.setInt(6, l.getLimiteTopicosEstudo());
			bd.st.setInt(7, l.getLimiteTopicosRevisao());
			bd.st.setInt(8, l.getHighscore());
			bd.st.executeUpdate();
			men = "Usuário inserido com sucesso!";
		} catch (SQLException erro) {
			sql = "update usuario set nome_usuario = ?, set senha_usuario = ?, set email_usuario = ?, set tipo_usuario = ?, set limite_estudo = ?, set limite_revisao = ?, set highscore_usuario = ? where cod_usuario = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(8, l.getCodigo());
				bd.st.setString(1, l.getUsuario());
				bd.st.setString(2, l.getSenha());
				bd.st.setString(3, l.getEmail());
				bd.st.setInt(4, l.getTipo());
				bd.st.setInt(5, l.getLimiteTopicosEstudo());
				bd.st.setInt(6, l.getLimiteTopicosRevisao());
				bd.st.setInt(7, l.getHighscore());
				bd.st.executeUpdate();
				men = "Usuario atualizado com sucesso";
			} catch (SQLException e) {
				men = "Falha " + erro;
			}
		} finally {
			bd.close();
		}
		return men;
	}
	
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
	 * @param usuario
	 * @return - numero limite de estudo
	 */
	public static int buscaLimiteEstudo(String usuario) {
		// tem que implementar para fazer a pesquisa no banco e encontrar esse valor
		return 10;
	}

	/**
	 * Buscar o limite de revisoes diarias do usuário
	 * 
	 * @param usuario
	 * @return - numero limite de revisoes
	 */
	public static int buscaLimiteRevisao(String usuario) {
		// tem que implementar para fazer a pesquisa no banco e encontrar esse valor
		return 11;
	}

	/**
	 * método que verifica se o usuário é um administrador
	 * 
	 * @param usuario - nome do usuario
	 * @param senha   - senha do usuario
	 * @return - true para usuario administrador
	 */
	public static boolean validaAdministrador(Login l) {
		return false;
	}

}
