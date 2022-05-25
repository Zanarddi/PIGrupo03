package testes;

import modelo.Login;
import crud.LoginDAO;

public class LoginInserir {

	static Login l = new Login(10, "Gustavo", "Zanardi", "email do zanardi", 10, 10, 10, 1);
	static LoginDAO dao = new LoginDAO();
	
	
	public static void main(String[] args) {
		for (int i=10;i<=15;i++) {
			l.setCodigo(i);
			l.setUsuario("Gustavo");
			l.setSenha("Zanardi");
			l.setEmail("email do zanardi");
			l.setLimiteTopicosEstudo(10);
			l.setLimiteTopicosRevisao(10);
			l.setHighscore(10);
			l.setTipo(1);
			dao.salvar(l);
			System.out.println(i);
		}
	}
}
