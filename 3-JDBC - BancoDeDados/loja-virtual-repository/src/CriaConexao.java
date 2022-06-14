import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// ConnectionFactory
public class CriaConexao {
	
	// Permite a exposicao da pool de conexoes para o resto da aplicacao
	public DataSource dataSource;
	
	public CriaConexao() {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		
		// cria e configura a pool de conexoes
		pool.setJdbcUrl(
			"jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC");
		pool.setUser("root");
		pool.setPassword("admin");
		pool.setMaxPoolSize(15);
		
		this.dataSource = pool;
	}
	
	// retorna a conexao com o dataSource
	public Connection recuperaConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
}
