package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Conecta e manipula o banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class BD {

	public Connection con = null; // realiza a conexão ao banco
	public PreparedStatement st = null; // executa instruções SQL
	public ResultSet rs = null; // armazena as querys

	public final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // driver de conexão ao banco
	public final String BANCO = "PIGrupo03"; // nome do banco
	public final String URL = "jdbc:sqlserver://localhost:1433;databasename=" + BANCO; // URL para se conectar ao
																							// banco, usar
																							// localhost:1433 caso
																							// queira usar o seu proprio
																							// ip

	public final String LOGIN = "sa";
	public final String SENHA = "123456789";

	/**
	 * Abre uma conexão com o banco de dados a partir dos dados definidos acima
	 * 
	 * @return - true em caso de sucesso ou false caso contrário
	 */
	public boolean getConnection() {
		// carregar o driver
		try {
			Class.forName(DRIVER); // carrega a classe do driver
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Sucesso!!");
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver não encontrado!!");
			return false;
		} catch (SQLException erro) {
			System.out.println("Falha na conexão!!!" + erro);
			return false;
		}
	}

	/**
	 * Encerra a conexão com o banco de dados
	 * 
	 * @return
	 */
	public void close() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException erro) {
		}
		try {
			if (st != null)
				st.close();
		} catch (SQLException erro) {
		}
		try {
			if (con != null) {
				con.close();
				System.out.println("Desconectou!!");
			}
		} catch (SQLException erro) {
		}
	}

	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
		bd.close();
	}
}