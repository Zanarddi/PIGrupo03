package modelo;

public class Topico {
	
	private int codigo;
	private int proficiencia;
	private int posicao;
	
	private String titulo;
	private String explicacao;
	
	Pergunta pergunta;
	
	public Topico(int codigo){
		this.codigo = codigo;
	}
	
	public Topico(int cod, int proficiencia, int pos, String tit, String exp, Pergunta p){
		this.codigo = cod;
		this.proficiencia = proficiencia;
		this.posicao = pos;
		this.titulo = tit;
		this.explicacao = exp;
		this.pergunta = p;
	}
	
}
