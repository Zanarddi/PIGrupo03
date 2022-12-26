package modelo;

import java.util.ArrayList;

import controle.Main;
import crud.TopicoDAO;

/**
 * Consiste em um arraylist com uma fila de estudo, onde s�o adicionados t�picos
 * que ainda n�o foram estudados
 * 
 * @author Gustavo Zanardi
 *
 */
public class Estudo {

	public ArrayList<Topico> filaEstudo;

	public Estudo() {
		atualizarFilaEstudo();
	}

	/**
	 * Atribui novos t�picos ao array de fila de estudos
	 */
	public void atualizarFilaEstudo() {
		filaEstudo = pesquisaEstudo();
		for (Topico topico : filaEstudo) {
			topico.criarTela();
		}
	}
	
	/**
	 * Consulta topicos a serem estudados no banco de dados
	 * 
	 * @return Array de t�picos a serem estudados
	 */
	public ArrayList<Topico> pesquisaEstudo() {
		
		String querySQL = "Select top " + (Main.login.getLimiteTopicosEstudo() - Main.login.getTopicosEstudados()) + " t.cod_topico, t.ordem_topico, p.proficiencia, t.titulo_topico, t.descricao_topico, te.nome_tema\r\n"
				+ "From proficiencia p, tema te, topico t, usuario u\r\n"
				+ "Where p.cod_topico = t.cod_topico \r\n"
				+ "and t.cod_tema = te.cod_tema \r\n"
				+ "and p.cod_usuario = u.cod_usuario\r\n"
				+ "and p.cod_usuario = " + Main.login.getCodigo() + " \r\n"
				+ "and p.proficiencia = 0";	
		
		TopicoDAO topicoDAO = new TopicoDAO();
		//est� apagado por enquanto, apenas para testes
		ArrayList<Topico> listaEstudo = topicoDAO.getEstudo(querySQL);
		//VERIFICAR
		return listaEstudo;
	}
}
