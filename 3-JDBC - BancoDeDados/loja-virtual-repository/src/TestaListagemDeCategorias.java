import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import DAO.PersistenciaProduto;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try (Connection con = new CriaConexao().recuperaConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			
			List<Categoria> categorias = categoriaDAO.listar();
			
			categorias.stream().forEach(ct -> { 
				
				try {
					for (Produto produto : new PersistenciaProduto(con)
							.buscar(ct)) {
						System.out.println(ct.getNome() + " - " 
								+ produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		} 
	}
}
