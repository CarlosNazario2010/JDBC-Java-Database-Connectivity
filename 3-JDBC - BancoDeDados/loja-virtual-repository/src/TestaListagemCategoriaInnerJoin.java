import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemCategoriaInnerJoin {

	public static void main(String[] args) throws SQLException {
		
		try (Connection con = new CriaConexao().recuperaConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			
			List<Categoria> categorias = categoriaDAO.listarComProdutos();
			
			categorias.stream().forEach(ct -> { 
				
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() 
							+ " - " + produto.getNome() + " - " 
									+ produto.getDescricao());
				}
			});
		} 
	}
}
