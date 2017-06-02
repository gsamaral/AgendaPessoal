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

/**
 * Classe para gerenciar as funcoes relacionadas a classe Tarefa
 * @author geovana
 *
 */
public class TarefaController {

	/**
	 * metodo que converte data de String p tipo Date
	 * @param data
	 * @return Date
	 * @throws ParseException
	 */
	private Date formatarData(String data) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return new Date(formatter.parse(data).getTime());
	}

		/**
		 * método que chama a funcao SQL para salvar
		 * @param nomeTarefa
		 * @param categoria
		 * @param status
		 * @param dataTarefa
		 * @param hora
		 * @param min
		 * @throws SQLException
		 * @throws ParseException
		 */
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

	/**
	 * método que chama a funcao SQL para alterar tarefa
	 * @param id
	 * @param nomeTarefa
	 * @param categoria
	 * @param status
	 * @param dataTarefa
	 * @param hora
	 * @param min
	 * @throws ParseException
	 * @throws SQLException
	 */
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

	/**
	 * método que chama a funcao SQL para excluir uma tarefa
	 * @param id
	 * @throws SQLException
	 */
	public void excluirTarefa(long id) throws SQLException {
		new TarefaSQL().Excluir(id);
	}
	
	/**
	 * metodo que chama a funcao SQL para pegar as tarefas do BD
	 * @return Lista de tarefas
	 */
	public List<AgendaPessoal> listaTarefas() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getLista();

	}
	/**
	 * metodo que chama a funcao SQL para pegar as tarefas do dia corrente do BD
	 * @return lista de tarefas
	 */
	public List<AgendaPessoal> pegaDia() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getDia();

	}
	/**
	 * metodo que chama a funcao SQL para pegar as tarefas do mes corrente do BD
	 * @return lista
	 */
	public List<AgendaPessoal> pegaMes() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getMes();

	}
	/**
	 * metodo que chama a funcao SQL para pegar as tarefas dos ultimos 7 dias 
	 * @return lista
	 */
	
	public List<AgendaPessoal> pegaSemana() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.getSemana();

	}
	/**
	 * metodo que chama a funcao SQL para pegar as tarefas com o status concluido
	 * @return
	 */
	
	public List<AgendaPessoal> statusConcluido() {
		TarefaSQL tarefas = new TarefaSQL();
		return tarefas.statusConcluido();

	}
	/**
	 * metodo que chama a funcao SQL para pegar a tarefa com o  nome como parametro
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public AgendaPessoal buscaContatoPorNome(String nome) throws SQLException {
        TarefaSQL dao = new TarefaSQL();
        return dao.findByName(nome);
    }
	
	/**
	 * metodo que chama a funcao SQL para pegar as tarefas de acordo com a categoria passada por parametro
	 * @param categoria
	 * @return
	 */
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
