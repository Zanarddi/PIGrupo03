package modelo;

public class Pergunta {

	private int codigo;
	
	private String descricao;
	
	private int codigoTopico;

	public Pergunta(int codigo, String descricao, int codigoTopico) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigoTopico = codigoTopico;
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
