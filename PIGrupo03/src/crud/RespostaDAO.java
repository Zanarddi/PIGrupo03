package crud;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Resposta;
import modelo.Topico;
import services.BD;

public class RespostaDAO {

	private String sql, men;
	private BD bd;
	
	public RespostaDAO() {
		bd = new BD();
	}
	
	/**
	 * método que busca uma lista de respostas no banco de dados
	 * 
	 * @param sql - query para busca
	 * @return
	 */
	public ArrayList<Resposta> get(String sql){
		ArrayList<Resposta> lista = new ArrayList<Resposta>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//implementar, colocando os campos corretos.
				lista.add(new Resposta(
						bd.rs.getString(1),
						bd.rs.getString(2),
						bd.rs.getInt(3))
				);
			}
		}
		catch(SQLException erro) {
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return lista;
	}
}
