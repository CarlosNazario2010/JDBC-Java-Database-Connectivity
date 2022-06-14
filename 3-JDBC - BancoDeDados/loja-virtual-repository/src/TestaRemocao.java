import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao novaCon = new CriaConexao();
		Connection con = novaCon.recuperaConexao();
		
		Integer inteiro = 2;
		
		PreparedStatement stm = con.prepareStatement(
				"DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, inteiro);
		stm.execute();
		
		int cont = stm.getUpdateCount();
		System.out.println("Quantidade de linhas afetadas: " + cont);
	}
}
