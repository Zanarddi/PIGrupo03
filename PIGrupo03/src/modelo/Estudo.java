package modelo;

import java.util.ArrayList;

public class Estudo {

	public ArrayList<Topico> filaEstudo;

	public Estudo() {
		atualizarFilaEstudo();
	}

	public void atualizarFilaEstudo() {
		// usa a funcao do crud para gerar o array com os topicos
		filaEstudo = crud.EstudoDAO.pesquisaEstudo();
	}
}
