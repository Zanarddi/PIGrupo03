package modelo;

import java.util.ArrayList;

import crud.RespostaDAO;

/**
 * Pergunta relacionada ao tópico. é utilizada apenas na tela de revisão, em um
 * cardlayout
 * 
 * @author Gustavo Zanardi
 *
 */
public class Pergunta {

	private int codigoTopico;
	
	private int codigo;
	
	private String descricao;
	
	private ArrayList<Resposta> respostas;
	
	
	public Pergunta(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		respostas = buscaResposta();
		
		}

	public Pergunta() {
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Resposta> buscaResposta() {
		
		RespostaDAO respostaDAO = new RespostaDAO();
		String sqlQuery = "Select r.cod_resposta, r.descricao_resposta, r.tipo_resposta \r\n"
				+ "From resposta r, pergunta p \r\n"
				+ "Where p.cod_pergunta = r.cod_pergunta \r\n"
				+ "and p.cod_pergunta = " + this.codigo;
		
		return respostaDAO.get(sqlQuery);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(ArrayList<Resposta> respostas) {
		this.respostas = respostas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoTopico() {
		return codigoTopico;
	}

	public void setCodigoTopico(int codigoTopico) {
		this.codigoTopico = codigoTopico;
	}
}
