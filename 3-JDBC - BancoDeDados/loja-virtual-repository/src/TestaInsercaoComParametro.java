import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		String nome = "MOUSE";
		String descricao = "MOUSE SEM FIO); delete from produto";
		
		CriaConexao novaCon = new CriaConexao();
		Connection con = novaCon.recuperaConexao();
		
		/*
		 *  PreparedStatement prepara o Statament e impede o SQL injection,
		 *  ou seja, que o usuario use um comando SQL para, por exemplo,
		 *  deletar a nossa tabela
		 */
		PreparedStatement stm = con.prepareStatement(
				"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
						Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}
}
