package modelo;

import componentesGUIPrincipal.TelaTopico;

public class Topico {
	
	private TelaTopico tela;
	
	

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

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
	
	public void criarTela() {
		this.setTela(new TelaTopico());
	}

	public TelaTopico getTela() {
		return tela;
	}

	public void setTela(TelaTopico tela) {
		this.tela = tela;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}
	
}
