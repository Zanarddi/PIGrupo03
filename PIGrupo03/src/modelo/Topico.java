package modelo;

import java.util.ArrayList;
import java.util.Collections;

import componentesGUIPrincipal.TelaPergunta;
import componentesGUIPrincipal.TelaTopico;
import crud.PerguntaDAO;
import crud.RespostaDAO;

/**
 * Classe s�o manipulados os t�picos do sistema.
 * � amplamente utilizada em diversas funcionalidades no sistema
 * 
 * @author Gustavo Zanardi
 *
 */
public class Topico {
	
	private TelaTopico tela;

	private TelaPergunta telaPergunta;
	
	private int codigo;
	private int posicao;
	
	private int proficiencia;
	
	private int codigoTema;
	
	private String titulo;
	private String explicacao;
	private String tema;
	
	private ArrayList<Pergunta> perguntas;
	
	public Topico(int codigo){
		this.codigo = codigo;
	}

	//cria��o de t�picos para estudo
	public Topico(int codigo, int posicao, int proficiencia, String titulo, String explicacao, String tema) {
		this.codigo = codigo;
		this.posicao = posicao;
		this.proficiencia = proficiencia;
		this.titulo = titulo;
		this.explicacao = explicacao;
		this.tema = tema;
	}
	
	//cria��o de t�picos para revis�o
	public Topico(int codigo,  String titulo, String explicacao, int proficiencia) {
		this.codigo = codigo;
		this.proficiencia = proficiencia;
		this.titulo = titulo;
		this.explicacao = explicacao;
		
		buscaPergunta();
	}


	/**
	 * M�todo que cria uma nova tela do tipo t�pico.
	 * Este processo n�o � realizado no construtor pois podem existirem situa��es em que ele n�o precisa ser iniciado
	 */
	public void criarTela() {
		this.setTela(new TelaTopico(this.titulo, this.tema, this.explicacao));
	}
	
	/**
	 * M�todo que cria uma nova tela do tipo pergunta.
	 * Este processo n�o � realizado no construtor pois podem existirem situa��es em que ele n�o precisa ser iniciado
	 */
	public void criarTelaPergunta() {
		Collections.shuffle(perguntas);
		this.setTelaPergunta(new TelaPergunta(perguntas.get(0)));
	}
	
	public ArrayList<Pergunta> buscaPergunta() {
		
		PerguntaDAO perguntaDAO = new PerguntaDAO();
		String sqlQuery = "Select p.cod_pergunta, p.descricao_pergunta \r\n"
				+ "From topico t, pergunta p u\r\n"
				+ "Where p.cod_topico = t.cod_topico \r\n"
				+ "Where t.cod_topico = " + this.codigo;
		
		return perguntaDAO.get(sqlQuery);
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

	public ArrayList<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(ArrayList<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public TelaPergunta getTelaPergunta() {
		return telaPergunta;
	}

	public void setTelaPergunta(TelaPergunta telaPergunta) {
		this.telaPergunta = telaPergunta;
	}
	
}
