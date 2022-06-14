
import java.sql.SQLException;

public class TestaPoolDeConexao {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Chamando conexao do pool de conexoes");
		
		CriaConexao novaCon = new CriaConexao();
		
		// pool com 15 conexoes criadas
		for (int i = 0; i < 20; i++) {
			novaCon.recuperaConexao();
			System.out.println("Conexao numero: " + i);
		}
	}
}