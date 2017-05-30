package br.edu.ufam.agenda.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.edu.ufam.agenda.Categoria;
import br.edu.ufam.agenda.sql.CategoriaSQL;
import br.edu.ufam.agenda.sql.TarefaSQL;

public class CategoriaController {

	public void salvarCat(String nomeCat) throws SQLException, ParseException {
		Categoria categorias = new Categoria();
		categorias.setNome(nomeCat);

		new CategoriaSQL().InserirCategoria(categorias);
	}

	public void alterarCat(int id, String nomeCat) throws ParseException, SQLException {

		Categoria categorias = new Categoria();
		categorias.setNome(nomeCat);

		new CategoriaSQL().AlterarCat(categorias);
	}

	public void excluirCat(int id) throws SQLException {
		new CategoriaSQL().ExcluirCat(id);
	}
	
	public List<Categoria> getCat() {
		CategoriaSQL cat = new CategoriaSQL();
		return cat.getCategoria();

	}
	
	public Categoria buscaContatoPorNomeCat(String nome) throws SQLException {
        CategoriaSQL cat = new CategoriaSQL();
        return cat.findCatByName(nome);
    }
	
	

}
