package br.com.carlosnazario.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.carlosnazario.jdbc.dao.CategoriaDAO;
import br.com.carlosnazario.jdbc.factory.ConnectionFactory;
import br.com.carlosnazario.jdbc.modelo.Categoria;

public class CategoriaController {
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		Connection connection = 
				new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}
	
	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
