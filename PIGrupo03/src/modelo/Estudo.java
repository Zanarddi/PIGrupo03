package modelo;

import java.util.ArrayList;

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
		// usa a funcao do crud para gerar o array com os topicos
		filaEstudo = crud.EstudoDAO.pesquisaEstudo();
	}
}
