package agenda;

import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TarefaSQL implements InterfaceTarefa {

	public TarefaSQL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Inserir() {
		// cria objeto
		AgendaPessoal tarefa = new AgendaPessoal();

		// Cria uma conexão com o banco
		Connection conn = Conect.getConnection();

		// Cria um PreparedStatment, classe usada para executar a query
//		Statement pstm = conn.createStatement();
	

	// Adiciona o valor do primeiro parâmetro da sql

	}

	@Override
	public void Alterar(int ID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Excluir(int ID) {
		// TODO Auto-generated method stub

	}

}
