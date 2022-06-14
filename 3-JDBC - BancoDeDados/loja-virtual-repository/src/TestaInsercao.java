import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao novaCon = new CriaConexao();
		Connection con = novaCon.recuperaConexao();
		
		Statement stm = con.createStatement();
		boolean exe = stm.execute("INSERT INTO PRODUTO (nome, descricao)"
				+ "VALUES ('MOUSE', 'MOUSE SEM FIO')",
				Statement.RETURN_GENERATED_KEYS);
		
		System.out.println("Retorno é uma tabela do banco? " + exe);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}	
	}
}
