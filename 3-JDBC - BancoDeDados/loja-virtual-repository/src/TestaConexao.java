
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		
		// cria a conexao com o drive e o path
		Connection connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "admin");
		
		System.out.println("Conexao estabelecida");
		connection.close();
		System.out.println("Conexao encerrada");
	}
}