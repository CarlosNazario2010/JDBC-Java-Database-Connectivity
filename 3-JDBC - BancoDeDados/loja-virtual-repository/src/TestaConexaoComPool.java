
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoComPool {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Chamando conexao do pool de conexoes");
		
		CriaConexao novaCon = new CriaConexao();
		Connection con = novaCon.recuperaConexao();
		
		System.out.println("Conexao estabelecida");
		con.close();
		System.out.println("Conexao encerrada");
	}
}