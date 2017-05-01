package agenda;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AgendaMain {
	
	

	public static void main(String[] args) {
		Connection connection = new Conect().getConnection();
		System.out.println("Conexão aberta!");
	

		
		AgendaPessoal tarefa1 = new AgendaPessoal();
		
		tarefa1.setNomeTarefa("festa");
		tarefa1.setCategoria("top");
		tarefa1.setStatus("realizado");
		
		
		TarefaSQL tarefaadd = new TarefaSQL();
		tarefaadd.Inserir(tarefa1);
		tarefaadd.Excluir(1);
		
		
		
	}

}
