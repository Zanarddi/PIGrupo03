package modelo;

import crud.LoginDAO;

public class Login {
	private String usuario;
	private String senha;
	private int limiteTopicosEstudo;
	private int limiteTopicosRevisao;
	
	
	public Login(String usuario, String senha){
		this.setUsuario(usuario);
		this.setSenha(senha);
		setLimiteTopicosEstudo(LoginDAO.buscaLimiteEstudo(usuario));
		setLimiteTopicosRevisao(LoginDAO.buscaLimiteRevisao(usuario));
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
}
