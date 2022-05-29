package modelo;

/**
 * Pergunta relacionada ao tópico.
 * é utilizada apenas na tela de revisão, e um cardlayout
 * @author Gustavo Zanardi
 *
 */
public class Pergunta {

	private int codigo;
	private String descricao;
	private int codigoTopico;

	public Pergunta(int codigo, String descricao, int codigoTopico) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigoTopico = codigoTopico;
	}

	public Pergunta(int i, String string, String string2, String string3, String string4, String string5,
			String string6, String string7) {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigoTopico() {
		return codigoTopico;
	}

	public void setCodigoTopico(int codigoTopico) {
		this.codigoTopico = codigoTopico;
	}

	

}
