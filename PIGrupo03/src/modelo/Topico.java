package modelo;

import componentesGUIPrincipal.TelaTopico;

public class Topico {
	
	private TelaTopico tela;

	private int codigo;
	private int posicao;
	private int proficiencia;
	
	private int codigoTema;
	
	private String titulo;
	private String explicacao;
	private String tema;
	
	
	Pergunta pergunta;
	
	public Topico(int codigo){
		this.codigo = codigo;
	}

	
	public Topico(int codigo, int posicao, int proficiencia, String titulo, String explicacao, String tema) {
		this.codigo = codigo;
		this.posicao = posicao;
		this.proficiencia = proficiencia;
		this.titulo = titulo;
		this.explicacao = explicacao;
		this.tema = tema;
	}


	/**
	 * Método que cria uma nova tela do tipo tópico.
	 * Este processo não é realizado no construtor pois podem existirem situações em que ele não precisa ser iniciado
	 */
	public void criarTela() {
		this.setTela(new TelaTopico(this.titulo, this.tema, this.explicacao));
	}

	public TelaTopico getTela() {
		return tela;
	}

	public void setTela(TelaTopico tela) {
		this.tela = tela;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}


	public int getCodigoTema() {
		return codigoTema;
	}


	public void setCodigoTema(int codigoTema) {
		this.codigoTema = codigoTema;
	}
	
}
