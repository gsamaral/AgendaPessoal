package br.edu.ufam.agenda.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.Categoria;
import br.edu.ufam.agenda.controller.CategoriaController;
import br.edu.ufam.agenda.controller.TarefaController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

public class CategoriaPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CategoriaPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1);

		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblPrximas = new JLabel("Categorias");
		GridBagConstraints gbc_lblPrximas = new GridBagConstraints();
		gbc_lblPrximas.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrximas.gridx = 0;
		gbc_lblPrximas.gridy = 0;
		panel_1.add(lblPrximas, gbc_lblPrximas);
		add(panel_1);

		JList list = new JList();
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setSize(new Dimension(75, 200));
		listScrollPane.getViewport().setView(list);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		panel_1.add(listScrollPane, gbc_list);

		JPanel panel_2 = new JPanel();
		add(panel_2);

		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblConteudoCategoria = new JLabel("Conteudo Categoria");
		GridBagConstraints gbc_ConteudoCategoria = new GridBagConstraints();
		gbc_ConteudoCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_ConteudoCategoria.gridx = 0;
		gbc_ConteudoCategoria.gridy = 0;
		panel_2.add(lblConteudoCategoria, gbc_ConteudoCategoria);
		add(panel_2);

		JList list2 = new JList();
		JScrollPane listScrollPane2 = new JScrollPane();
		listScrollPane2.setSize(new Dimension(75, 200));
		listScrollPane2.getViewport().setView(list2);
		GridBagConstraints gbc_list2 = new GridBagConstraints();
		gbc_list2.fill = GridBagConstraints.BOTH;
		gbc_list2.gridx = 0;
		gbc_list2.gridy = 2;
		panel_2.add(listScrollPane2, gbc_list2);

		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(null);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(53, 31, 117, 29);
		panel_3.add(btnAdicionar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(182, 31, 117, 29);
		panel_3.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(311, 31, 117, 29);
		panel_3.add(btnExcluir);

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaCat novaCat = new NovaCat();
				novaCat.setVisible(true);
				// TarefaController tf = new TarefaController();
				// List<AgendaPessoal> lista = tf.listaTarefas();
				// textField.setText(lista.get(0).getNomeTarefa());

			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaController edit = new CategoriaController();

				if (list.getSelectedValue() != null) {
					String item = (String) list.getSelectedValue();
					String[] itemLista = item.split(" ");
					String s = itemLista[0].toString();
					System.out.println(s);

					
					try {
						EditarCat editcat = new EditarCat(edit.buscaContatoPorNomeCat(s));
						editcat.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar um item", "Message",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
//		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaController cat = new CategoriaController();

				if (list.getSelectedValue() != null) {
					String item = (String) list.getSelectedValue();
					String[] itemLista = item.split(" ");
					String s = itemLista[0].toString();
					System.out.println(s);

					
					try {
						ExcluirCat exc = new ExcluirCat(cat.buscaContatoPorNomeCat(s));
						exc.setVisible(true);
						System.out.println(exc);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar um item", "Message",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
//
		list.addListSelectionListener(new ListSelectionListener() {
			  public void valueChanged(ListSelectionEvent evt) {
			    if (!evt.getValueIsAdjusting()) {
			    	JList source = (JList)evt.getSource();
		            String selected = source.getSelectedValue().toString();
		            TarefaController ct = new TarefaController();
		    		//resolver a consulta
		            List<AgendaPessoal> recebe = ct.pegaNomeporcategoria(selected);
		    		list2.setModel(new AbstractListModel() {
		    			public int getSize() {
		    				return recebe.size();
		    			}
		    			public Object getElementAt(int index) {
		    				return recebe.get(index).getNomeTarefa();
		    			}
		    		});
			      // code here
			    }
			  }
			});
		// -----------

		// TarefaController tf = new TarefaController();
		// List<AgendaPessoal> recebe = tf.pegaDia();
		CategoriaController ct = new CategoriaController();
		List<Categoria> recebe = ct.getCat();

		list.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe.size();
			}

			public Object getElementAt(int index) {
				return recebe.get(index).getNome();
			}
		});
//TODO Habilitar foco para atualizar as listas e pegar conteudo do item selecionado
		
		
		
	}
	
	
	

}