package modelo;

import java.util.ArrayList;

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
		// usa a funcao do crud para gerar o array com os topicos
		filaEstudo = crud.EstudoDAO.pesquisaEstudo();
	}
}
