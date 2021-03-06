package br.edu.ufam.agenda.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.controller.TarefaController;

import java.awt.GridLayout;
import javax.swing.JButton;

public class InicioPanel extends JPanel {
	JList list;

	/**
	 * Create the panel.
	 */
	public InicioPanel() {
		setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_1 = new JPanel();

		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 30, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblPrximas = new JLabel("Todas as Atividades");
		GridBagConstraints gbc_lblPrximas = new GridBagConstraints();
		gbc_lblPrximas.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrximas.gridx = 0;
		gbc_lblPrximas.gridy = 0;
		panel_1.add(lblPrximas, gbc_lblPrximas);
		add(panel_1);

		list = new JList();
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setSize(new Dimension(75, 200));
		listScrollPane.getViewport().setView(list);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		panel_1.add(listScrollPane, gbc_list);

		JList list_1 = new JList();

		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 20, 20, 20, 0, 20, 0, 0 };
		gbl_panel.rowHeights = new int[] { 20, 20, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 3;
		gbc_btnAdicionar.gridy = 2;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		JButton btnEditar = new JButton("Editar");
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 4;
		gbc_btnEditar.gridy = 2;
		panel.add(btnEditar, gbc_btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 5;
		gbc_btnExcluir.gridy = 2;
		panel.add(btnExcluir, gbc_btnExcluir);

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefaController edit = new TarefaController();

				if (list.getSelectedValue() != null) {
					String item = (String) list.getSelectedValue();
					String[] itemLista = item.split(" ");
					String s = itemLista[0].toString();
					System.out.println(s);

					try {
						EditarAtividade1 editTarefa = new EditarAtividade1(edit.buscaContatoPorNome(s));
						editTarefa.setVisible(true);
						editTarefa.addWindowListener(new java.awt.event.WindowAdapter(){
							@Override
							public void windowClosed(java.awt.event.WindowEvent windowEvent){
								list.setModel(new AbstractListModel() {
									TarefaController tf = new TarefaController();
									List<AgendaPessoal> recebe = tf.listaTarefas();
									public int getSize() {
										return recebe.size();
									}

									public Object getElementAt(int index) {
										return recebe.get(index).getNomeTarefa() + " " + recebe.get(index).getDataTarefa();
									}

								});
							}
						});
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar um item", "Message",
							JOptionPane.ERROR_MESSAGE);
				}

				// TarefaController tf = new TarefaController();
				// List<AgendaPessoal> lista = tf.listaTarefas();
				// textField.setText(lista.get(0).getNomeTarefa());

			}
		});
		
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefaController delete = new TarefaController();

				if (list.getSelectedValue() != null) {
					String item = (String) list.getSelectedValue();
					String[] itemLista = item.split(" ");
					String s="";
					for(int i=0;i<(itemLista.length-1);i++){
						s+=itemLista[i].toString();
						if(i!=itemLista.length-1){
							s+=" ";
						}
					}
					
					AgendaPessoal nome;
					
					try {
						nome = delete.buscaContatoPorNome(s);
						delete.excluirTarefa(nome.getId());
						JOptionPane.showMessageDialog(null, "Atividade excluída");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					list.setModel(new AbstractListModel() {
						TarefaController tf = new TarefaController();
						List<AgendaPessoal> recebe = tf.listaTarefas();
						public int getSize() {
							return recebe.size();
						}

						public Object getElementAt(int index) {
							return recebe.get(index).getNomeTarefa() + " " + recebe.get(index).getDataTarefa();
						}

					});
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar um item", "Message",
							JOptionPane.ERROR_MESSAGE);
				}

				// TarefaController tf = new TarefaController();
				// List<AgendaPessoal> lista = tf.listaTarefas();
				// textField.setText(lista.get(0).getNomeTarefa());

			}
		});

		TarefaController tf = new TarefaController();
		List<AgendaPessoal> recebe = tf.listaTarefas();
		DefaultListModel model = new DefaultListModel();
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe.size();
			}

			public Object getElementAt(int index) {
				return recebe.get(index).getNomeTarefa() + " " + recebe.get(index).getDataTarefa();
			}

		});

		List<AgendaPessoal> recebe2 = tf.statusConcluido();
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe2.size();
			}

			public Object getElementAt(int index) {
				return recebe2.get(index).getNomeTarefa() + " " + recebe2.get(index).getDataTarefa();
			}

		});

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaAtividade novaAtv = new NovaAtividade();
				
				novaAtv.setVisible(true);
				novaAtv.addWindowListener(new java.awt.event.WindowAdapter(){
					@Override
					public void windowClosed(java.awt.event.WindowEvent windowEvent){
						list.setModel(new AbstractListModel() {
							TarefaController tf = new TarefaController();
							List<AgendaPessoal> recebe = tf.listaTarefas();
							public int getSize() {
								return recebe.size();
							}

							public Object getElementAt(int index) {
								return recebe.get(index).getNomeTarefa() + " " + recebe.get(index).getDataTarefa();
							}

						});
					}
				});
				// TarefaController tf = new TarefaController();
				// List<AgendaPessoal> lista = tf.listaTarefas();
				// textField.setText(lista.get(0).getNomeTarefa());

			}
		});
	}
	
	
	

}