package testes;

import java.util.List;

import model.Login;
import model.LoginDAO;

public class LoginListar {

	public static void main(String[] args) {
		LoginDAO dao = new LoginDAO();
		List<Login> lista = 
				dao.get("select * from usuario");
		
		for(Login l:lista) {
			System.out.println(l);
		}
	}
}
