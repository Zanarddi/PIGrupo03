package modelo;

public class Resposta {

	private String codigo;
	private String descricao;
	private int tipo;

	public Resposta(String codigo, String descricao, int tipo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
