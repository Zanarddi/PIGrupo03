package crud;

import java.util.ArrayList;

import modelo.Topico;

public class EstudoDAO {
	
	/**
	 * Consulta topicos a serem estudados no banco de dados
	 * 
	 * @param limiteTopicos - limite estabelecido pelo usuario
	 * @return - array de topicos a serem estudados
	 */
	public static ArrayList<Topico> pesquisaEstudo() {
		int limite = controle.Main.limiteTopicosEstudo;
		/*
		 * PRECISA IMPLEMENTAR!!!
		 *
		 * Buscar no banco de dados as primeiras [limite] linhas que tenham: -usuario do
		 * bd igual ao do usuario no programa -tenham uma data de proximo estudo
		 * inferior a data atual, importante lembrar que a ordem seja essa subtração, de
		 * forma decrescente -retornar um arrayList com os topicos já criados
		 * 
		 */
		return null;
	}

}
