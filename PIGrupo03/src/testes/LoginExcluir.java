package testes;

import crud.LoginDAO;

public class LoginExcluir {

	public static void main(String[] args) {
		LoginDAO dao = new LoginDAO();
		System.out.println(dao.excluir(10));

	}
}
