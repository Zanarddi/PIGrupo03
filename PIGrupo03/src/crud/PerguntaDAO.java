package crud;

import java.sql.SQLException;
import java.util.ArrayList;

import log.Log;
import modelo.Pergunta;
import services.BD;

/**
 * Classe que manipula dados referentes a perguntas no banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class PerguntaDAO {

	private String sql, men;
	private BD bd;

	public PerguntaDAO() {
		bd = new BD();
	}

	/**
	 * método que busca uma lista de perguntas no banco de dados
	 * 
	 * @param sql - query para busca
	 * @return
	 */
	public ArrayList<Pergunta> get(String sql) {
		ArrayList<Pergunta> lista = new ArrayList<Pergunta>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				// implementar, colocando os campos corretos.
				lista.add(new Pergunta(bd.rs.getInt(1), bd.rs.getString(2)));
			}
		} catch (SQLException erro) {
			System.out.println(erro);
		} finally {
			bd.close();
		}
		return lista;
	}

	/**
	 * Exclui uma pergunta no banco de dados
	 * 
	 * @param pergunta - a ser excluída
	 * @return - de confirmação
	 */
	public String excluir(Pergunta pergunta) {
		sql = "delete pergunta where cod_pergunta = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, pergunta.getCodigo());
			if (bd.st.executeUpdate() == 1) {
				men = "Pergunta excluída com sucesso!";
				Log.manterObjeto(pergunta, 0);
			}
			else
				men = "Pergunta não foi encontrada!";
		} catch (SQLException erro) {
			men = "Falha na exclusão " + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	
	/**
	 * Atualiza os dados de uma pergunta no banco de dados
	 * @param p - pergunta a ser atualizada
	 * @return - confirmação da operação
	 */
	public String salvar(Pergunta p) {
		sql = "update pergunta set descricao_pergunta = ?, cod_topico = ? where cod_pergunta = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(3, p.getCodigo());
			bd.st.setString(1, p.getDescricao());
			bd.st.setInt(2, p.getCodigoTopico());
			bd.st.executeUpdate();
			men = "Pergunta atualizada com sucesso";
			Log.manterObjeto(p, 2);
		} catch (SQLException erro) {
			men = "" + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	
	/**
	 * cria uma nova pergunta no banco de dados
	 * 
	 * @param descricao - pergunta
	 * @param codigoTopico - da pergunta
	 * @return - confirmação da operação
	 */
	public String criarNovo(String descricao, int codigoTopico) {
		sql = "Insert into pergunta(descricao_pergunta, cod_topico) Values (?, ?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, descricao);
			bd.st.setInt(2, codigoTopico);
			bd.st.executeUpdate();
			men = "Pergunta inserida com sucesso!";
			Log.manterObjeto(new Pergunta(), 1);
		} catch (SQLException erro) {
			men = "" + erro;
		} finally {
			bd.close();
		}
		return men;
	}
}
