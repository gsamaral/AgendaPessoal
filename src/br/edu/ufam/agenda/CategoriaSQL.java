package br.edu.ufam.agenda;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ufam.agenda.conexao.ConnectionDatabase;

public class CategoriaSQL extends SQLGenerico{

	private Connection connection;
	
	public CategoriaSQL()  {
		// TODO Auto-generated constructor stub
		this.connection = new ConnectionDatabase().getConnection();
	}
	
	public void InserirCategoria(Categoria categoria) throws SQLException {
		// cria objeto
		// Cria uma conexão com o banco
		String insert = "insert into Categoria " + "(nomeCat) " + "values (?)";
		saveCat(insert, categoria.getNome());

	}
	
	public void AlterarCat(Categoria categoria) throws SQLException {
		// TODO Auto-generated method stub
		String update = "UPDATE Categoria SET nomeTarefa = ?" + " WHERE id = ?";
		updateCat(update, categoria.getId(),categoria.getNome());
		//		tarefa.getDataTarefa(),tarefa.getHora(),tarefa.getMin());

	}

	public void Excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM Categoria WHERE id = ?";
		deleteCat(delete, id);

	}
	

}
