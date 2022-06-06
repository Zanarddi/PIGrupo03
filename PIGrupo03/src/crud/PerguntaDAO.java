package crud;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pergunta;
import modelo.Resposta;
import services.BD;

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
}
