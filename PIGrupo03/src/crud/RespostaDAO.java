package crud;

import java.sql.SQLException;
import java.util.ArrayList;

import log.Log;
import modelo.Pergunta;
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
						bd.rs.getInt(1),
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
	
	public String excluir(Resposta resposta) {
		sql = "delete resposta where cod_resposta = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, resposta.getCodigo());
			if (bd.st.executeUpdate() == 1) {
				men = "Resposta excluída com sucesso!";
				Log.manterObjeto(resposta, 0);
			} else
				men = "Resposta não foi encontrada!";
		} catch (SQLException erro) {
			men = "Falha na exclusão " + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	
	public String salvar(Resposta r) {
		sql = "update resposta set descricao_resposta = ?, tipo_resposta = ?, cod_pergunta = ? where cod_resposta = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(4, r.getCodigo());
			bd.st.setString(1, r.getDescricao());
			bd.st.setInt(2, r.getTipo());
			bd.st.setInt(3, r.getCodigoPergunta());
			bd.st.executeUpdate();
			men = "Resposta atualizada com sucesso";
			Log.manterObjeto(r, 2);
		} catch (SQLException erro) {
			men = "" + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	
	public String criarNovo(String descricao, int tipo, int codigoPergunta) {
		sql = "Insert into resposta(descricao_resposta, tipo_resposta, cod_pergunta) Values (?, ?, ?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, descricao);
			bd.st.setInt(2, tipo);
			bd.st.setInt(3, codigoPergunta);
			bd.st.executeUpdate();
			men = "Resposta inserida com sucesso!";
			Log.manterObjeto(new Resposta(), 1);
		} catch (SQLException erro) {
			men = "" + erro;
		} finally {
			bd.close();
		}
		return men;
		
	}
}
