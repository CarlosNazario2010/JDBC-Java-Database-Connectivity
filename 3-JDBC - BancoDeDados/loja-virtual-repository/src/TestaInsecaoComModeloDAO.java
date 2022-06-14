import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.PersistenciaProduto;
import modelo.Produto;

public class TestaInsecaoComModeloDAO {

	public static void main(String[] args) throws SQLException {
		
		Produto produto = new Produto("Comoda", "Comoda Vertical");
		
		try (Connection con = new CriaConexao().recuperaConexao()) {
			
			PersistenciaProduto pp = new PersistenciaProduto(con);
			pp.salvarProduto(produto);
			List<Produto> lp = pp.listarProduto();
			lp.stream().forEach(lista -> System.out.println(lista));
		}
	}
}
