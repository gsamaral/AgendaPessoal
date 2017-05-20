package agenda;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class TarefaController {

	private Date formatarData(String data) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return new Date(formatter.parse(data).getTime());
	}

	public void salvarTarefa(String nomeTarefa, String categoria, String status, String dataTarefa)
			throws SQLException, ParseException {
		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setNomeTarefa(nomeTarefa);
		tarefas.setCategoria(categoria);
		tarefas.setStatus(status);
		tarefas.setDataTarefa(formatarData(dataTarefa));

		new TarefaSQL().Inserir(tarefas);
	}
	
	public void salvarTarefa(String nomeTarefa, String categoria, String status, Date dataTarefa)
			throws SQLException, ParseException {
		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setNomeTarefa(nomeTarefa);
		tarefas.setStatus(status);
		tarefas.setCategoria(categoria);
		tarefas.setDataTarefa(dataTarefa);

		new TarefaSQL().Inserir(tarefas);
	}

	public void alterarTarefa(int id, String nomeTarefa, String categoria, String status, String dataTarefa)
			throws ParseException, SQLException {

		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setId(id);
		tarefas.setCategoria(categoria);
		tarefas.setStatus(status);
		tarefas.setNomeTarefa(nomeTarefa);
		tarefas.setDataTarefa(formatarData(dataTarefa));

		new TarefaSQL().Alterar(tarefas);
	}

	public void excluirTarefa(int id) throws SQLException {
		new TarefaSQL().Excluir(id);
	}
	
	

	
	
	public List<AgendaPessoal> listaTarefas() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getLista();

	}
	
	public List<AgendaPessoal> pegaDia() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getDia();

	}
	
	public List<AgendaPessoal> pegaMes() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getMes();

	}
	
	public List<AgendaPessoal> pegaSemana() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getSemana();

	}

}
