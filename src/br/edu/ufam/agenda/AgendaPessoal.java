package br.edu.ufam.agenda;

import java.util.Date;

public class AgendaPessoal {

	
	private int id;
	private String nomeTarefa, categoria, status,data;
	private Date dataTarefa;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataTarefa() {
		return dataTarefa;
	}
	public void setDataTarefa(Date dataTarefa) {
		this.dataTarefa = dataTarefa;
	}
	
	

}