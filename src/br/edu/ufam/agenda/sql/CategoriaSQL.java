package br.edu.ufam.agenda.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.Categoria;

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
		String update = "UPDATE Categoria SET nomeCat = ?" + " WHERE idCat = ?";
		updateCat(update, categoria.getId(),categoria.getNome());
		//		tarefa.getDataTarefa(),tarefa.getHora(),tarefa.getMin());

	}

	public void ExcluirCat(int id) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM Categoria WHERE idCat = ?";
		deleteCat(delete, id);

	}
	
	public List<Categoria> getCategoria() {
		Connection conn = null;
		try {
			conn = new ConnectionDatabase().getConnection();

			List<Categoria> categorias = new ArrayList<Categoria>();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Categoria");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto viagem
				Categoria cat = new Categoria();
				// viagem.setIdViagem(rs.getInt("idViagem"));
				cat.setNome(rs.getString("nomeCat"));
				
				// adicionando o objeto à lista
				categorias.add(cat);
			}
			rs.close();
			stmt.close();
			return categorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Categoria findCatByName(String nome) throws SQLException {
        String select = "SELECT * FROM Categoria WHERE nomeCat = ?;";
        Categoria categoria = new Categoria();
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	categoria.setNome(rs.getString("nomeCat"));
			
        }

        rs.close();
        stmt.close();
        return categoria;
    }

	

}
