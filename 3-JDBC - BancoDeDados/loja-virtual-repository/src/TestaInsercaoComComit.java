import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComComit {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao novaCon = new CriaConexao();
		
		/* Ao utilizar o try-with-resources, não é mais necessário explicitar o 
		 * close para fechar o statements (ResultSet, Connection, PreparedStatement)
		 */
		try (Connection con = novaCon.recuperaConexao()) {
			
			// nao insere o comit no banco automaticamente
			con.setAutoCommit(false);
			
			try (PreparedStatement stm = con.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
						Statement.RETURN_GENERATED_KEYS)) {
				
				adicionaItem("SmartTV", "45 polegadas", stm);
				adicionaItem("Radio", "Radio de Bateria", stm);
				
				// realiza o commit somente se e quando TODOS os comandos
				// SQL forem realizados
				con.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
				// se houver um exception, realiza o rollback, ou seja,
				// desfaz todos os comandos SQL
				con.rollback();
				System.out.println("ROLLBACK EXECUTADO");
			}
		}	
	}
	
	private static void adicionaItem (String nome, String descricao,
			PreparedStatement stm) throws SQLException {
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		try (ResultSet rst = stm.getGeneratedKeys()) {
			
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
}
