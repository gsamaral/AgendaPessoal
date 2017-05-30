package br.edu.ufam.agenda.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.sql.TarefaSQL;

public class TarefaController {

	private Date formatarData(String data) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return new Date(formatter.parse(data).getTime());
	}

	public void salvarTarefa(String nomeTarefa, String categoria, String status, String dataTarefa,int hora, int min)
			throws SQLException, ParseException {
		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setNomeTarefa(nomeTarefa);
		tarefas.setCategoria(categoria);
		tarefas.setStatus(status);
		tarefas.setDataTarefa(formatarData(dataTarefa));
		tarefas.setHora(hora);
		tarefas.setMin(min);
		new TarefaSQL().Inserir(tarefas);
	}
	
	public void salvarTarefa(String nomeTarefa, String categoria, String status, Date dataTarefa,int hora, int min)
			throws SQLException, ParseException {
		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setNomeTarefa(nomeTarefa);
		tarefas.setStatus(status);
		tarefas.setCategoria(categoria);
		tarefas.setDataTarefa(dataTarefa);
		tarefas.setHora(hora);
		tarefas.setMin(min);
		new TarefaSQL().Inserir(tarefas);
	}

	public void alterarTarefa(int id, String nomeTarefa, String categoria, String status, Date dataTarefa,int hora, int min)
			throws ParseException, SQLException {

		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setId(id);
		tarefas.setCategoria(categoria);
		tarefas.setStatus(status);
		tarefas.setNomeTarefa(nomeTarefa);
		tarefas.setDataTarefa(dataTarefa);
		tarefas.setHora(hora);
		tarefas.setMin(min);
		new TarefaSQL().Alterar(tarefas);
	}

	public void excluirTarefa(int id) throws SQLException {
		AgendaPessoal tarefas = new AgendaPessoal();
		tarefas.setId(id);
		
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
	
	public List<AgendaPessoal> statusConcluido() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.statusConcluido();

	}
	
	public AgendaPessoal buscaContatoPorNome(String nome) throws SQLException {
        TarefaSQL dao = new TarefaSQL();
        return dao.findByName(nome);
    }
	
	public List<AgendaPessoal> pegaNomeporcategoria(String categoria) {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.pegaTarefaPorCategoria(categoria);

	}
	
//	public List<String> addCategoria(String categoria) {
//		ArrayList<String> cat = new ArrayList<String>();
//		cat.add(categoria);
//		return cat;
//	}
//	
//	

}
