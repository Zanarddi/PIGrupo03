package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controle.Main;
import modelo.Login;
import services.BD;

/**
 * Classe que manipula dados referentes ao login no banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
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
	 * Cria um novo usuário no banco de dados
	 * @param l - objeto login a ser criado
	 * @return - mensagem com retorno da operação
	 */
	public String registrarUsuario(Login l) {
		sql = "insert into usuario (nome_usuario, senha_usuario, email_usuario, tipo_usuario, limite_estudo, limite_revisao, highscore_usuario) values (?,?,?,?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, l.getUsuario());
			bd.st.setString(2, l.getSenha());
			bd.st.setString(3, l.getEmail());
			bd.st.setInt(4, l.getTipo());
			bd.st.setInt(5, l.getLimiteTopicosEstudo());
			bd.st.setInt(6, l.getLimiteTopicosRevisao());
			bd.st.setInt(7, l.getHighscore());
			bd.st.executeUpdate();
			men = "Usuário inserido com sucesso!";
		} catch (SQLException e) {
			men = "Usuário já existe";
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
		sql = "insert into usuario (nome_usuario, senha_usuario, email_usuario, tipo_usuario, limite_estudo, limite_revisao, highscore_usuario) values (?,?,?,?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, l.getUsuario());
			bd.st.setString(2, l.getSenha());
			bd.st.setString(3, l.getEmail());
			bd.st.setInt(4, l.getTipo());
			bd.st.setInt(5, l.getLimiteTopicosEstudo());
			bd.st.setInt(6, l.getLimiteTopicosRevisao());
			bd.st.setInt(7, l.getHighscore());
			bd.st.executeUpdate();
			men = "Usuário inserido com sucesso!";
		} catch (SQLException erro) {
			sql = "update usuario set nome_usuario = ?, senha_usuario = ?, email_usuario = ?, tipo_usuario = ?, limite_estudo = ?, limite_revisao = ?, highscore_usuario = ? where cod_usuario = ?";
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
				men = "Falha " + e;
			}
		} finally {
			bd.close();
		}
		return men;
	}
	
	/**
	 * Cria uma lista de usuários buscados no banco 
	 * @param sql - query usada pelo sql server
	 * @return - lista com os usuários encontrados
	 */
	public List<Login> get(String sql){
		List<Login> lista = new ArrayList<Login>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				lista.add(new Login(
						bd.rs.getInt(1),
						bd.rs.getString(2),
						bd.rs.getString(3),
						bd.rs.getString(4),
						bd.rs.getInt(5),
						bd.rs.getInt(6),
						bd.rs.getInt(7),
						bd.rs.getInt(8))
				);
			}
		}
		catch(SQLException erro) {
			lista = null;
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return lista;
	}

	/**
	 * método que valida o login, buscando valores no banco de dados.
	 * 
	 * @param usuario - string do username
	 * @param senha   - senha do usuário
	 * @return - um objeto do tipo login. caso o retorno seja null, as credenciais
	 *         não são válidas.
	 */
	public static Login validarLogin(String usuario, String senha) {
		List<Login> login;
		String sql = "SELECT cod_usuario, nome_usuario, senha_usuario, email_usuario, limite_estudo, limite_revisao, highscore_usuario, tipo_usuario FROM usuario WHERE nome_usuario = '"
				+ usuario + "' AND senha_usuario = '" + senha + "'";
		LoginDAO lDAO = new LoginDAO();
		login = lDAO.get(sql);
		
		if(login.isEmpty()) {
			return null;
		}
		else {
		}
		return login.get(0);
	}
}
