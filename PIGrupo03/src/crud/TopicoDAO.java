package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Login;
import modelo.Topico;
import services.BD;

public class TopicoDAO {

	private String sql, men;
	private BD bd;

	public TopicoDAO() {
		bd = new BD();
	}

	public String salvar(Topico t) {
		sql = "insert into topico (cod_topico, ordem_topico, titulo_topico, descricao_topico, cod_tema) values (?,?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, t.getCodigo());
			bd.st.setInt(2, t.getPosicao());
			bd.st.setString(3, t.getTitulo());
			bd.st.setString(4, t.getExplicacao());
			bd.st.setInt(5, t.getCodigoTema());
			bd.st.executeUpdate();
			men = "Topico inserido com sucesso!";
		} catch (SQLException erro) {
			sql = "update topico set ordem_topico = ?, set titulo_topico = ?, set descricao_topico = ?, set cod_tema = ? where cod_topico = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(5, t.getCodigo());
				bd.st.setInt(1, t.getPosicao());
				bd.st.setString(2, t.getTitulo());
				bd.st.setString(3, t.getExplicacao());
				bd.st.setInt(4, t.getCodigoTema());

				bd.st.executeUpdate();
				men = "Topico atualizado com sucesso";
			} catch (SQLException e) {
				men = "Falha " + erro;
			}
		} finally {
			bd.close();
		}
		return men;
	}

	public String excluir(int codigo) {
		sql = "delete topico where cod_topico = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			if (bd.st.executeUpdate() == 1)
				men = "Topico excluído com sucesso!";
			else
				men = "Topico não foi encontrado!";
		} catch (SQLException erro) {
			men = "Falha na exclusão " + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	
	
	/**
	 * faz a busca de tópicos no banco com parâmetros específicos para uma fila de estudo
	 * 
	 * @param sql - query sql para busca
	 * @return - array de tópicos
	 */
	public ArrayList<Topico> getEstudo(String sql){
		ArrayList<Topico> lista = new ArrayList<Topico>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//implementar, colocando os campos corretos.
				lista.add(new Topico(
						bd.rs.getInt(1),
						bd.rs.getInt(2),
						bd.rs.getInt(3),
						bd.rs.getString(4),
						bd.rs.getString(5),
						bd.rs.getString(6),
						bd.rs.getInt(7))
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
	 * faz a busca de tópicos no banco com parâmetros específicos para uma fila de revisão
	 * 
	 * @param sql - query sql para busca
	 * @return - array de tópicos
	 */
	public ArrayList<Topico> getRevisao(String sql){
		ArrayList<Topico> lista = new ArrayList<Topico>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//implementar, colocando os campos corretos.
				
				//int codigo, int proficiencia, String titulo, 
				//String explicacao, int codigoProficiencia
				lista.add(new Topico(
						bd.rs.getInt(1),
						bd.rs.getString(2),
						bd.rs.getString(3),
						bd.rs.getInt(4),
						bd.rs.getInt(5))
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
	 * Atualiza a proficiencia de um topico no banco de dados
	 * @param topico
	 */
	public void salvarProficiencia(ArrayList<Topico> topicos) {
		bd.getConnection();
		sql = "update proficiencia set proficiencia = ?, where cod_proficiencia = ?";
		
		
		
		//IMPLEMENTAR PRA O USO DO ARRAY
		
		try {
			bd.st = bd.con.prepareStatement(sql);
			
			bd.st.setInt(2, topico.getCodigoProficiencia());
			bd.st.setInt(1, topico.getProficiencia());

			bd.st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
