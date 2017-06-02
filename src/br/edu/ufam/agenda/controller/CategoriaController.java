package br.edu.ufam.agenda.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.edu.ufam.agenda.Categoria;
import br.edu.ufam.agenda.sql.CategoriaSQL;
import br.edu.ufam.agenda.sql.TarefaSQL;

/**
 * Classe para controle das funcoes que executam o sql de Categoria
 * @author geovana
 *
 */
public class CategoriaController {
	

	/**
	 * chama a função SQL para Salvar Categoria
	 * @param nomeCat
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void salvarCat(String nomeCat) throws SQLException, ParseException {
		Categoria categorias = new Categoria();
		categorias.setNome(nomeCat);

		new CategoriaSQL().InserirCategoria(categorias);
	}
	/**
	 * Chama a funçao SQL para alterar categoria
	 * @param id
	 * @param nomeCat
	 * @throws ParseException
	 * @throws SQLException
	 */
	public void alterarCat(int id, String nomeCat) throws ParseException, SQLException {

		Categoria categorias = new Categoria();
		categorias.setNome(nomeCat);

		new CategoriaSQL().AlterarCat(categorias);
	}

	/**
	 * Chama a método sql de excluir categoria
	 * @param id
	 * @throws SQLException
	 */
	public void excluirCat(long id) throws SQLException {
		new CategoriaSQL().ExcluirCat(id);
	}
	
	/**
	 * Chama a método sql que pega as categorias
	 * @return Lista de categorias
	 */
	public List<Categoria> getCat() {
		CategoriaSQL cat = new CategoriaSQL();
		return cat.getCategoria();

	}
	
	/**
	 * Chama a método sql que busca a atividade de acordo com a categoria
	 * @param nome
	 * @return 
	 * @throws SQLException
	 */
	public Categoria buscaContatoPorNomeCat(String nome) throws SQLException {
        CategoriaSQL cat = new CategoriaSQL();
        return cat.findCatByName(nome);
    }
	
	

}
