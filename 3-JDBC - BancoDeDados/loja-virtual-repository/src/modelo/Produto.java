package modelo;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto (Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public void setId(Integer id) {
		this.id = id;	
	}
	
	@Override
	public String toString() {
		return String.format("O produto �: %d, %s, %s", 
				this.id, this.nome, this.descricao);
	}
}
