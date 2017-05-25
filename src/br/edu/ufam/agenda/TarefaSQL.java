package br.edu.ufam.agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufam.agenda.conexao.ConnectionDatabase;

public class TarefaSQL extends TarefasGenerico {

	private Connection connection;

	public TarefaSQL() {
		this.connection = new ConnectionDatabase().getConnection();
	}

	public void Inserir(AgendaPessoal tarefa) throws SQLException {
		// cria objeto
		// Cria uma conexão com o banco
		String insert = "insert into TAREFA " + "(nomeTarefa,categoria,status,dataTarefa,hora,min) " + "values (?,?,?,?,?,?)";
		save(insert, tarefa.getNomeTarefa(), tarefa.getCategoria(), tarefa.getStatus(), tarefa.getDataTarefa(),tarefa.getHora(),tarefa.getMin());

	}
	
	

	public void Alterar(AgendaPessoal tarefa) throws SQLException {
		// TODO Auto-generated method stub
		String update = "UPDATE TAREFA SET nomeTarefa = ?, categoria = ?, status=?, dataTarefa=?,hora=?,min=?" + " WHERE id = ?";
		update(update, tarefa.getId(), tarefa.getNomeTarefa(), tarefa.getCategoria(), tarefa.getStatus(),
				tarefa.getDataTarefa(),tarefa.getHora(),tarefa.getMin());

	}

	public void Excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM TAREFA WHERE id = ?";
		delete(delete, id);

	}
	
	public void pegaDia() throws SQLException {
		// TODO Auto-generated method stub
		AgendaPessoal data = new AgendaPessoal();
		Connection conn = new ConnectionDatabase().getConnection();
		PreparedStatement stmt = conn.prepareStatement("Select Day(dataTarefa) From TAREFA; ");
		System.out.println(stmt);
	}
	
	public List<AgendaPessoal> getLista() {
		Connection conn = null;
		try {
			conn = new ConnectionDatabase().getConnection();

			List<AgendaPessoal> tarefas = new ArrayList<AgendaPessoal>();

			PreparedStatement stmt = conn.prepareStatement("select * from TAREFA");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto viagem
				AgendaPessoal tarefa = new AgendaPessoal();
				// viagem.setIdViagem(rs.getInt("idViagem"));
				tarefa.setNomeTarefa(rs.getString("nomeTarefa"));
				tarefa.setCategoria(rs.getString("categoria"));
				tarefa.setId(rs.getInt("id"));
				tarefa.setStatus(rs.getString("status"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				tarefa.setHora(rs.getInt("hora"));
				tarefa.setMin(rs.getInt("min"));
				// adicionando o objeto à lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<AgendaPessoal> getDia() {
		Connection conn = null;
		try {
			conn = new ConnectionDatabase().getConnection();

			List<AgendaPessoal> tarefas = new ArrayList<AgendaPessoal>();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TAREFA where Day(dataTarefa) = Day(Now());");
			ResultSet rs = stmt.executeQuery();
			AgendaPessoal tarefa = new AgendaPessoal();
			while (rs.next()) {
				// criando o objeto viagem
				tarefa.setNomeTarefa(rs.getString("nomeTarefa"));
				tarefa.setCategoria(rs.getString("categoria"));
				tarefa.setId(rs.getInt("id"));
				tarefa.setStatus(rs.getString("status"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				tarefa.setHora(rs.getInt("hora"));
				tarefa.setMin(rs.getInt("min"));
				// adicionando o objeto à lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<AgendaPessoal> getMes() {
		Connection conn = null;
		try {
			conn = new ConnectionDatabase().getConnection();

			List<AgendaPessoal> tarefas = new ArrayList<AgendaPessoal>();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TAREFA where MONTH(dataTarefa) = MONTH(Now());");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto viagem
				AgendaPessoal tarefa = new AgendaPessoal();
				// viagem.setIdViagem(rs.getInt("idViagem"));
				tarefa.setNomeTarefa(rs.getString("nomeTarefa"));
				tarefa.setCategoria(rs.getString("categoria"));
				tarefa.setId(rs.getInt("id"));
				tarefa.setStatus(rs.getString("status"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				tarefa.setHora(rs.getInt("hora"));
				tarefa.setMin(rs.getInt("min"));
				// adicionando o objeto à lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<AgendaPessoal> getSemana() {
		Connection conn = null;
		try {
			conn = new ConnectionDatabase().getConnection();

			List<AgendaPessoal> tarefas = new ArrayList<AgendaPessoal>();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TAREFA WHERE dataTarefa BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW();");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto viagem
				AgendaPessoal tarefa = new AgendaPessoal();
				// viagem.setIdViagem(rs.getInt("idViagem"));
				tarefa.setNomeTarefa(rs.getString("nomeTarefa"));
				tarefa.setCategoria(rs.getString("categoria"));
				tarefa.setId(rs.getInt("id"));
				tarefa.setStatus(rs.getString("status"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				tarefa.setHora(rs.getInt("hora"));
				tarefa.setMin(rs.getInt("min"));
				// adicionando o objeto à lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<AgendaPessoal> statusConcluido() {
		Connection conn = null;
		try {
			conn = new ConnectionDatabase().getConnection();

			List<AgendaPessoal> tarefas = new ArrayList<AgendaPessoal>();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TAREFA WHERE status='concluída';");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto viagem
				AgendaPessoal tarefa = new AgendaPessoal();
				// viagem.setIdViagem(rs.getInt("idViagem"));
				tarefa.setNomeTarefa(rs.getString("nomeTarefa"));
				tarefa.setCategoria(rs.getString("categoria"));
				tarefa.setId(rs.getInt("id"));
				tarefa.setStatus(rs.getString("status"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				tarefa.setHora(rs.getInt("hora"));
				tarefa.setMin(rs.getInt("min"));
				// adicionando o objeto à lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public AgendaPessoal findByName(String nome) throws SQLException {
        String select = "SELECT * FROM TAREFA WHERE nomeTarefa = ?";
        AgendaPessoal tarefas = new AgendaPessoal();
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	tarefas.setNomeTarefa(rs.getString("nomeTarefa"));
			tarefas.setCategoria(rs.getString("categoria"));
			tarefas.setId(rs.getInt("id"));
			tarefas.setStatus(rs.getString("status"));
			tarefas.setDataTarefa(rs.getDate("dataTarefa"));
			tarefas.setHora(rs.getInt("hora"));
			tarefas.setMin(rs.getInt("min"));
        }

        rs.close();
        stmt.close();
        return tarefas;
    }

}
