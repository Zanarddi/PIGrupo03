package modelo;

import java.util.ArrayList;

import controle.Main;
import crud.TopicoDAO;

public class Revisao {
	
	ArrayList<Topico> filaRevisao;
	
	public Revisao() {
		atualizarFilaRevisao();
	}
	
	/**
	 * atribui novos tópicos ao array da fila de revisao
	 */
	public void atualizarFilaRevisao() {
		filaRevisao = pesquisaRevisao();
	}
	
	/**
	 * Consulta topicos a serem revisados no banco de dados
	 * 
	 * @return Array de tópicos a serem estudados
	 */
	public ArrayList<Topico> pesquisaRevisao() {
		
		String querySQL = "Select top " + (Main.login.getLimiteTopicosRevisao() - Main.login.getTopicosRevisados()) + " t.cod_topico, t.titulo_topico, t.descricao_topico, p.cod_proficiencia, p.proficiencia \r\n"
				+ "From proficiencia p, topico t, usuario u\r\n"
				+ "Where p.cod_topico = t.cod_topico \r\n"
				+ "and p.cod_usuario = u.cod_usuario \r\n"
				+ "and p.proficiencia <> 0 \r\n"
				+ "and p.cod_usuario = " + Main.login.getCodigo() + " \r\n"
				+ "and proxima_revisao < getdate() ";	
		
		TopicoDAO topicoDAO = new TopicoDAO();
		
		ArrayList<Topico> listaRevisao = topicoDAO.getRevisao(querySQL);
		
		return listaRevisao;
	}
}
