package br.edu.ufam.agenda;

import java.util.Date;

/**
 * Classe que representa uma Atividade/Tarefa de uma agenda pessoal
 * @author Geovana Amaral gsamaral05@gmail.com
 *
 */
public class AgendaPessoal {

	/**
	 * Atributos classe Agenda Pessoal
	 * 
	 */
	private int id;
	
	private String nomeTarefa, categoria, status,data;
	private Date dataTarefa;
	private int hora,min;
	
	
	/**
	 * Pega hora 
	 * @return int hora da atividade
	 */
	
	public int getHora() {
		return hora;
	}
	
	/**
	 * Seta hora
	 * @param hora
	 */
	public void setHora(int hora) {
		this.hora = hora;
	}
	/**
	 * pega minutos
	 * @return int minuto
	 */
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	/**
	 * pega data
	 * @return String data
	 */
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * pega o id
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * pega o nome da atividade
	 * @return String nome da atividade
	 */
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	
	/**
	 * pega a categoria da atv
	 * @return String categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * pega o status da atv
	 * @return String status
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * pega  a data da tarefa no tipo Date
	 * @return Date dataTarefa
	 */
	public Date getDataTarefa() {
		return dataTarefa;
	}
	public void setDataTarefa(Date dataTarefa) {
		this.dataTarefa = dataTarefa;
	}
	
	

}
