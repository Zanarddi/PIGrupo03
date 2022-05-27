package crud;

import java.util.ArrayList;

import modelo.Pergunta;
import modelo.Topico;

public class EstudoDAO {

	/**
	 * Consulta topicos a serem estudados no banco de dados
	 * 
	 * @return Array de tópicos a serem estudados
	 */
	public static ArrayList<Topico> pesquisaEstudo() {
		
		String querySQL = null;
		/*
		 * PRECISA IMPLEMENTAR!!!
		 *
		 * Buscar no banco de dados as primeiras [limite] linhas que tenham: -usuario do
		 * bd igual ao do usuario no programa -tenham uma data de proximo estudo
		 * inferior a data atual, importante lembrar que a ordem seja essa subtração, de
		 * forma decrescente -retornar um resultset com os topicos já criados
		 * 
		 * deve retornar, em ordem: int codigo, int posicao, int proficiencia, String titulo, String explicacao, String tema
		 * 
		 */
		
		
		TopicoDAO topicoDAO = new TopicoDAO();
		
		//está apagado por enquanto
		//ArrayList<Topico> listaEstudo = topicoDAO.get(querySQL);
		
		ArrayList<Topico> listaEstudo = new ArrayList<Topico>();
		Topico testeTopico = new Topico(1, 1, 1, "Isso é um título", "Isso é uma explicação", "Isso é um tema");
		listaEstudo.add(testeTopico);
		
		return listaEstudo;
	}

}
