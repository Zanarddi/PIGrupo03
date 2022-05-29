package modelo;

public class Login {
	
	private String usuario, senha, email;
	
	private int limiteTopicosEstudo = 3;
	private int limiteTopicosRevisao;
	private int highscore;
	private int tipo;
	private int codigo;
	
	private int topicosEstudados = 0;
	private int topicosRevisados = 0;

	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Login(int codigo, String usuario, String senha, String email, int limiteTopicosEstudo, int limiteTopicosRevisao,
			int highscore, int tipo) {
		this.usuario = usuario;
		this.senha = senha;
		this.setEmail(email);
		this.limiteTopicosEstudo = limiteTopicosEstudo;
		this.limiteTopicosRevisao = limiteTopicosRevisao;
		this.setHighscore(highscore);
		this.setTipo(tipo);
		this.setCodigo(codigo);
	}

	public String toString() {
		return ("[" + this.codigo + ", " + this.usuario + ", " + this.senha+ ", " + this.email+ ", " + this.limiteTopicosEstudo + ", " + this.limiteTopicosRevisao + ", " + this.highscore + ", " + this.tipo + ", ");
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getLimiteTopicosEstudo() {
		return limiteTopicosEstudo;
	}

	public void setLimiteTopicosEstudo(int limiteTopicosEstudo) {
		this.limiteTopicosEstudo = limiteTopicosEstudo;
	}

	public int getLimiteTopicosRevisao() {
		return limiteTopicosRevisao;
	}

	public void setLimiteTopicosRevisao(int limiteTopicosRevisao) {
		this.limiteTopicosRevisao = limiteTopicosRevisao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTopicosEstudados() {
		return topicosEstudados;
	}

	public void setTopicosEstudados(int topicosEstudados) {
		this.topicosEstudados = topicosEstudados;
	}

	public int getTopicosRevisados() {
		return topicosRevisados;
	}

	public void setTopicosRevisados(int topicosRevisados) {
		this.topicosRevisados = topicosRevisados;
	}
}
