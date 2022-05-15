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
		ArrayList<Topico> listaEstudo = null;
		int limite = controle.Main.limiteTopicosEstudo;
		/*
		 * PRECISA IMPLEMENTAR!!!
		 *
		 * Buscar no banco de dados as primeiras [limite] linhas que tenham: -usuario do
		 * bd igual ao do usuario no programa -tenham uma data de proximo estudo
		 * inferior a data atual, importante lembrar que a ordem seja essa subtração, de
		 * forma decrescente -retornar um resultset com os topicos já criados
		 * 
		 */
		
		/*
		 * Converter o resultset para arraylist. para isso preciso implementar a conexão com o banco
		 * 
		 */
		
		/*
		for (int i = 0; i < listaEstudo.size(); i++) {
			listaEstudo.set(i, new Topico(1, 2, 100, "teste", "apenas um teste", new Pergunta(1,
					"Esta é uma pergunta teste", "Correto", "erro1", "erro2", "erro3", "erro4", "erro5")));
		}
		*/
		return listaEstudo;
	}

}
