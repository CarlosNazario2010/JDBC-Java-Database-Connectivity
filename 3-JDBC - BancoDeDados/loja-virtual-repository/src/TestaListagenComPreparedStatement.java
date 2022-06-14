import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagenComPreparedStatement {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao novaCon = new CriaConexao();
		Connection con = novaCon.recuperaConexao();

		PreparedStatement stm = con.prepareStatement(
				"SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			System.out.println(id + " - " + nome + " - " + descricao);
		}
		
		con.close();
	}
}
