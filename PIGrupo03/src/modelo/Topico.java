package modelo;

import java.util.ArrayList;

import componentesGUIPrincipal.TelaTopico;
import crud.PerguntaDAO;
import crud.RespostaDAO;

/**
 * Classe são manipulados os tópicos do sistema.
 * É amplamente utilizada em diversas funcionalidades no sistema
 * 
 * @author Gustavo Zanardi
 *
 */
public class Topico {
	
	private TelaTopico tela;

	private int codigo;
	private int posicao;
	
	private int proficiencia;
	private int codigoProficiencia;
	
	private int codigoTema;
	
	private String titulo;
	private String explicacao;
	private String tema;
	
	private ArrayList<Pergunta> perguntas;
	
	public Topico(int codigo){
		this.codigo = codigo;
	}

	//criação de tópicos para estudo
	public Topico(int codigo, int posicao, int proficiencia, String titulo, String explicacao, String tema, int codigoProficiencia) {
		this.codigo = codigo;
		this.posicao = posicao;
		this.proficiencia = proficiencia;
		this.titulo = titulo;
		this.explicacao = explicacao;
		this.tema = tema;
	}
	
	//criação de tópicos para revisão
	public Topico(int codigo,  String titulo, String explicacao, int codigoProficiencia, int proficiencia) {
		this.codigo = codigo;
		this.proficiencia = proficiencia;
		this.titulo = titulo;
		this.explicacao = explicacao;
		this.codigoProficiencia = codigoProficiencia;
		
		buscaPergunta();
	}


	/**
	 * Método que cria uma nova tela do tipo tópico.
	 * Este processo não é realizado no construtor pois podem existirem situações em que ele não precisa ser iniciado
	 */
	public void criarTela() {
		this.setTela(new TelaTopico(this.titulo, this.tema, this.explicacao));
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


	public int getCodigoProficiencia() {
		return codigoProficiencia;
	}


	public void setCodigoProficiencia(int codigoProficiencia) {
		this.codigoProficiencia = codigoProficiencia;
	}

	public ArrayList<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(ArrayList<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
}
