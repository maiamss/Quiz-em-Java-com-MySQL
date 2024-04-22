
package QuizGame;

/*
Essa classe estabelece uma conexão entre o Java e o Banco de Dados
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Logger;

public class Conexao {

	public static Connection conectaBD() {

		Connection con = null;

		try {

			String url = "jdbc:mysql://localhost:3306/QuizGamePOO?user=root&password=&useSSL=false";
			con = DriverManager.getConnection(url);

		} catch (SQLException error) {
			System.out.println("ERRO AO CONECTAR BANCO DE DADOS");
			JOptionPane.showMessageDialog(null, error);
		}
		return con;

	}

	public static boolean closeConnection() {

		try {
			// fecha a conexao
			Conexao.conectaBD().close();
			return true;
		} catch (SQLException error) {
			System.out.println("ERRO AO FECHAR CONEXAO COM BANCO DE DADOS");
			JOptionPane.showMessageDialog(null, error);
			return false;
		}
	}
}
