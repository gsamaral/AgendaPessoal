package br.edu.ufam.agenda.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.Categoria;
/**
 * Classe que faz as execuções SQL referente a tabela Categoria do banco Planner
 * @author geovana
 *
 */
public class CategoriaSQL extends SQLGenerico{
	/**
	 * atributo do tipo connection
	 */
	private Connection connection;
	
	public CategoriaSQL()  {
		// TODO Auto-generated constructor stub
		this.connection = new ConnectionDatabase().getConnection();
	}
	
	/**
	 * metodo que insere um categoria na tabela
	 * @param categoria
	 * @throws SQLException
	 */
	public void InserirCategoria(Categoria categoria) throws SQLException {
		// cria objeto
		// Cria uma conexão com o banco
		String insert = "insert into Categoria " + "(nomeCat) " + "values (?)";
		saveCat(insert, categoria.getNome());

	}
	/**
	 * metodo que altera um categoria na tabela
	 * @param categoria
	 * @throws SQLException
	 */
	public void AlterarCat(Categoria categoria) throws SQLException {
		// TODO Auto-generated method stub
		String update = "UPDATE Categoria SET nomeCat = ?" + " WHERE idCat = ?";
		updateCat(update, categoria.getId(),categoria.getNome());
		//		tarefa.getDataTarefa(),tarefa.getHora(),tarefa.getMin());

	}
	/**
	 * metodo que exclui um categoria na tabela
	 * @param categoria
	 * @throws SQLException
	 */
	public void ExcluirCat(long id) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM Categoria WHERE idCat = ?";
		deleteCat(delete, id);

	}
	/**
	 * metodo que lista as categorias da tabela
	 * @param categoria
	 * @throws SQLException
	 */
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
	
	/**
	 * metodo que busca uma categoria pelo nome
	 * @param categoria
	 * @throws SQLException
	 */
	public Categoria findCatByName(String nome) throws SQLException {
        String select = "SELECT * FROM Categoria WHERE nomeCat = ?";
        
        Categoria categoria = new Categoria();
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
			categoria.setNome(rs.getString("nomeCat"));
			categoria.setId(rs.getInt("idCat"));
        }

        rs.close();
        stmt.close();
        return categoria;
    }



	

}
