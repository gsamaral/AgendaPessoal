package br.edu.ufam.agenda;

/**
 * Classe Categoria representa uma categoria de uma atividade
 * @author geovana
 *
 */
public class Categoria {
	/** id da categoria */
	private int id;
	/**
	 * nome da Categoria
	 */
	private String nome;
	
	/**
	 * retorna um id
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * retorna o nome da categoria
	 * 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
