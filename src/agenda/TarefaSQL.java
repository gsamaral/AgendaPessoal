package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaSQL extends TarefasGenerico {

	private Connection connection;

	public TarefaSQL() {
		this.connection = new ConnectionDatabase().getConnection();
	}

	public void Inserir(AgendaPessoal tarefa) throws SQLException {
		// cria objeto
		// Cria uma conexão com o banco
		String insert = "insert into TAREFA " + "(nomeTarefa,categoria,status,data) " + "values (?,?,?,?)";
		save(insert, tarefa.getNomeTarefa(), tarefa.getCategoria(), tarefa.getStatus(), tarefa.getDataTarefa());

	}

	public void Alterar(AgendaPessoal tarefa) throws SQLException {
		// TODO Auto-generated method stub
		String update = "UPDATE TAREFA SET nomeTarefa = ?, categoria = ?, status=?, dataTarefa=?" + " WHERE id = ?";
		update(update, tarefa.getId(), tarefa.getNomeTarefa(), tarefa.getCategoria(), tarefa.getStatus(),
				tarefa.getDataTarefa());

	}

	public void Excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM TAREFA WHERE id = ?";
		delete(delete, id);

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

}
