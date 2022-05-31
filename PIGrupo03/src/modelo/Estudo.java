package modelo;

import java.util.ArrayList;

import controle.Main;
import crud.TopicoDAO;

/**
 * Consiste em um arraylist com uma fila de estudo, onde são adicionados tópicos
 * que ainda não foram estudados
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
	 * Atribui novos tópicos ao array de fila de estudos
	 */
	public void atualizarFilaEstudo() {
		filaEstudo = pesquisaEstudo();
	}
	
	/**
	 * Consulta topicos a serem estudados no banco de dados
	 * 
	 * @return Array de tópicos a serem estudados
	 */
	public ArrayList<Topico> pesquisaEstudo() {
		
		String querySQL = "Select top " + (Main.login.getLimiteTopicosEstudo() - Main.login.getTopicosEstudados()) + " t.cod_topico, t.ordem_topico, p.proficiencia, t.titulo_topico, t.descricao_topico, te.nome_tema, p.cod_proficiencia\r\n"
				+ "From proficiencia p, tema te, topico t, usuario u\r\n"
				+ "Where p.cod_topico = t.cod_topico \r\n"
				+ "and t.cod_tema = te.cod_tema \r\n"
				+ "and p.cod_usuario = u.cod_usuario\r\n"
				+ "and p.cod_usuario = " + Main.login.getCodigo() + " \r\n"
				+ "and p.proficiencia = 0";	
		
		TopicoDAO topicoDAO = new TopicoDAO();
		
		//está apagado por enquanto, apenas para testes
		//ArrayList<Topico> listaEstudo = topicoDAO.get(querySQL);
		

		ArrayList<Topico> listaEstudo = new ArrayList<Topico>();
		Topico testeTopico = new Topico(1, 1, 1, "Isso é um título", "Isso é uma explicação1", "Isso é um tema1", 0);
		listaEstudo.add(testeTopico);
		testeTopico = new Topico(2, 1, 1, "Isso é um título2", "Isso é uma explicação2", "Isso é um tema2", 0);
		listaEstudo.add(testeTopico);
		testeTopico = new Topico(3, 1, 1, "Isso é um título3", "Isso é uma explicação3", "Isso é um tema3", 0);
		listaEstudo.add(testeTopico);
		
		return listaEstudo;
	}
}
