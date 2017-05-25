package br.edu.ufam.agenda;

import java.sql.SQLException;
import java.text.ParseException;

public class CategoriaController {

	public void salvarTarefa(String nomeCat) throws SQLException, ParseException {
		Categoria categorias = new Categoria();
		categorias.setNome(nomeCat);

		new CategoriaSQL().InserirCategoria(categorias);
	}

	public void alterarTarefa(int id, String nomeCat) throws ParseException, SQLException {

		Categoria categorias = new Categoria();
		categorias.setNome(nomeCat);

		new CategoriaSQL().AlterarCat(categorias);
	}

	public void excluirTarefa(int id) throws SQLException {
		new CategoriaSQL().Excluir(id);
	}

}
