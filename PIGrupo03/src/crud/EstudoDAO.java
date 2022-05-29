package crud;

import java.util.ArrayList;

import modelo.Pergunta;
import modelo.Topico;

public class EstudoDAO {

	/**
	 * Consulta topicos a serem estudados no banco de dados
	 * 
	 * @return Array de t�picos a serem estudados
	 */
	public static ArrayList<Topico> pesquisaEstudo() {
		
		String querySQL = null;
		/*
		 * PRECISA IMPLEMENTAR!!!
		 *
		 * Buscar no banco de dados as primeiras [limite] linhas que tenham: -usuario do
		 * bd igual ao do usuario no programa -tenham uma data de proximo estudo
		 * inferior a data atual, importante lembrar que a ordem seja essa subtra��o, de
		 * forma decrescente -retornar um resultset com os topicos j� criados
		 * 
		 * deve retornar, em ordem: int codigo, int posicao, int proficiencia, String titulo, String explicacao, String tema
		 * 
		 */
		
		
		TopicoDAO topicoDAO = new TopicoDAO();
		
		//est� apagado por enquanto
		//ArrayList<Topico> listaEstudo = topicoDAO.get(querySQL);
		
		ArrayList<Topico> listaEstudo = new ArrayList<Topico>();
		Topico testeTopico = new Topico(1, 1, 1, "Isso � um t�tulo", "Isso � uma explica��o1", "Isso � um tema1", 0);
		listaEstudo.add(testeTopico);
		testeTopico = new Topico(2, 1, 1, "Isso � um t�tulo2", "Isso � uma explica��o2", "Isso � um tema2", 0);
		listaEstudo.add(testeTopico);
		testeTopico = new Topico(3, 1, 1, "Isso � um t�tulo3", "Isso � uma explica��o3", "Isso � um tema3", 0);
		listaEstudo.add(testeTopico);
		
		return listaEstudo;
	}

}
