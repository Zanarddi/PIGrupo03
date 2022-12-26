package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.CalculoProficiencia;
import controle.Main;
import log.Log;
import modelo.Login;
import modelo.Topico;
import services.BD;

/**
 * Classe que manipula dados referentes a t�picos no banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class TopicoDAO {

	private String sql, men;
	private BD bd;

	public TopicoDAO() {
		bd = new BD();
	}
	
	/**
	 * Faz uma buscas de novos t�picos que n�o foram cadastrados para o usu�rio na profici�ncia
	 * 
	 */
	public ArrayList<Integer> pesquisarNovosTopicos() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		bd.getConnection();
		sql = "SELECT cod_topico FROM topico T WHERE NOT EXISTS (SELECT 1 FROM proficiencia P WHERE P.cod_topico = T.cod_topico AND P.cod_usuario = "+ Main.login.getCodigo() + ")";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				lista.add(bd.rs.getInt(1));
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
	
	

	/**
	 * cria um novo t�pico no banco de dados
	 * 
	 * @param titulo - do t�pico
	 * @param descricao -do t�pico
	 * @param ordem - do t�pico
	 * @return - string de confirma��o
	 */
	public String criarNovo(String titulo, String descricao, int ordem) {
		sql = "Insert into topico(titulo_topico, descricao_topico, ordem_topico, cod_tema) Values (?, ?, ?, 1)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, titulo);
			bd.st.setString(2, descricao);
			bd.st.setInt(3, ordem);
			bd.st.executeUpdate();
			men = "Topico inserido com sucesso!";
			Log.manterObjeto(new Topico(0), 1);
		} catch (SQLException erro) {
			men = "" + erro;
		} finally {
			bd.close();
		}
		return men;
	}

	/**
	 * m�todo que busca uma lista de t�picos no banco de dados
	 * 
	 * @param sql - query a ser executada pelo banco
	 * @return - confirma��o da opera��o
	 */
	public ArrayList<Topico> get(String sql){
		ArrayList<Topico> lista = new ArrayList<Topico>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				lista.add(new Topico(
						bd.rs.getInt(1),
						bd.rs.getInt(2),
						bd.rs.getString(3),
						bd.rs.getString(4))
				);
			}
		}catch(SQLException erro) {
			lista = null;
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return lista;
	}

	/**
	 * Atualiza os dados de um t�pico no banco de dados
	 * 
	 * @param t - t�pico a ser atualizado
	 * @return - confirma��o da opera��o
	 */
	public String salvar(Topico t) {
		sql = "update topico set ordem_topico = ?, titulo_topico = ?, descricao_topico = ? where cod_topico = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(4, t.getCodigo());
			bd.st.setInt(1, t.getPosicao());
			bd.st.setString(2, t.getTitulo());
			bd.st.setString(3, t.getExplicacao());
			bd.st.executeUpdate();
			men = "Topico atualizado com sucesso";
			Log.manterObjeto(t, 2);
		} catch (SQLException erro) {
			men = "" + erro;
		} finally {
			bd.close();
		}
		return men;
	}

	/**
	 * Exclui um t�pico no banco de dados
	 * 
	 * @param topico - a ser exclu�do
	 * @return - confirma��o da opera��o
	 */
	public String excluir(Topico topico) {
		sql = "delete topico where cod_topico = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, topico.getCodigo());
			if (bd.st.executeUpdate() == 1) {
				men = "Topico exclu�do com sucesso!";
				Log.manterObjeto(topico, 0);
			}
			else
				men = "Topico n�o foi encontrado!";
		} catch (SQLException erro) {
			men = "Falha na exclus�o " + erro;
		} finally {
			bd.close();
		}
		return men;
	}
	
	/**
	 * faz a busca de t�picos no banco com par�metros espec�ficos para uma fila de estudo
	 * 
	 * @param sql - query sql para busca
	 * @return - array de t�picos
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
						bd.rs.getString(6))
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
	 * faz a busca de t�picos no banco com par�metros espec�ficos para uma fila de revis�o
	 * 
	 * @param sql - query sql para busca
	 * @return - array de t�picos
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
						bd.rs.getInt(4))
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
	 * cria novas linhas de proficiencia para novos usuarios
	 * @param topicos
	 */
	public void inserirProficiencia(ArrayList<Integer> topicos, int codigoUsuario) {
		bd.getConnection();
		sql = "insert into proficiencia (cod_topico,cod_usuario) values (?,?)";
		
		for (Integer topico : topicos) {
			try {
				bd.st = bd.con.prepareStatement(sql);

				System.out.println(topico.intValue());
				System.out.println(codigoUsuario);
				
				bd.st.setInt(1, topico.intValue());
				bd.st.setInt(2, codigoUsuario);

				bd.st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		}
		bd.close();
	}
	
	/**
	 * Atualiza a proficiencia de um topico no banco de dados
	 * @param topico
	 */
	public void salvarProficiencia(ArrayList<Topico> topicos) {
		bd.getConnection();
		sql = "update proficiencia set proficiencia = ?, proxima_revisao = getdate() + ?  where cod_topico = ? and cod_usuario = ?";
		
		for (Topico topico : topicos) {
			try {
				bd.st = bd.con.prepareStatement(sql);

				bd.st.setInt(1, topico.getProficiencia());
				bd.st.setInt(2, CalculoProficiencia.calcularProficiencia(topico));
				bd.st.setInt(3, topico.getCodigo());
				bd.st.setInt(4, Main.login.getCodigo());

				bd.st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		}
		bd.close();
	}
	
	/**
	 * conta quantos topicos existem com n proficiencia para determinado usu�rio
	 * @param sql
	 * @return
	 */
	public int contarTopicos(String sql) {
		int contagem = 0;
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				contagem = bd.rs.getInt(1);
			}
		}
		catch(SQLException erro) {
			System.out.println(erro);
		}
		finally {
			bd.close();
		}
		return contagem;
	}
	
	/**
	 * lista o codigo dos topicos no banco
	 * utilizado no registro de novos usuarios
	 * @return
	 */
	public ArrayList<Integer> listarTopicos() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		sql = "select cod_topico from topico";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				lista.add(bd.rs.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println(erro);
		} finally {
			bd.close();
		}
		return lista;
	}
}
