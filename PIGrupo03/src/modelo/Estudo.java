package modelo;

import java.util.ArrayList;

public class Estudo {
	
	ArrayList<Topico> filaEstudo;
	
	Estudo(){
		//usa a funcao do crud para gerar o array com os topicos
		filaEstudo = crud.PesquisaTopicos.pesquisaEstudo();
		
	}
}