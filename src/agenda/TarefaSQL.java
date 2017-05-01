package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TarefaSQL implements InterfaceTarefa {

	private Connection connection;

	public TarefaSQL() {
		this.connection = new Conect().getConnection();
	}

	@Override
	public void Inserir(AgendaPessoal tarefa) {
		// cria objeto

		// Cria uma conexão com o banco

		String sql = "insert into TAREFA " + "(nomeTarefa,categoria,status) " + "values (?,?,?)";

		PreparedStatement pstm = null;

		try {
			connection = new Conect().getConnection();
			//

			// Cria uma conexão com o banco

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = connection.prepareStatement(sql);

			// //Adiciona o valor do primeiro parâmetro da sql

			pstm.setString(1, tarefa.getNomeTarefa());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, tarefa.getCategoria());
			pstm.setString(3, tarefa.getStatus());
			// Adiciona o valor do terceiro parâmetro da sql

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void Alterar(AgendaPessoal tarefa) {
		// TODO Auto-generated method stub
		String sql = "UPDATE TAREFA SET nomeTarefa = ?, categoria = ?, status=?" + " WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = new Conect().getConnection();
			//

			// Cria uma conexão com o banco

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// //Adiciona o valor do primeiro parâmetro da sql

			pstm.setString(1, tarefa.getNomeTarefa());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, tarefa.getCategoria());
			pstm.setString(3, tarefa.getStatus());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setInt(4, tarefa.getId());
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void Excluir(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM TAREFA WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = new Conect().getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

}
