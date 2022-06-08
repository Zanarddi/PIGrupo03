package modelo;

/**
 * Respostas para perguntas de tópicos, é utilizada nas sessões de estudo.
 * 
 * @author Gustavo Zanardi
 *
 */
public class Resposta {

	private int codigoPergunta;
	
	private int codigo;
	private String descricao;
	private int tipo;

	public Resposta(int codigo, String descricao, int tipo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public Resposta() {
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCodigoPergunta() {
		return codigoPergunta;
	}

	public void setCodigoPergunta(int codigoPergunta) {
		this.codigoPergunta = codigoPergunta;
	}
}
