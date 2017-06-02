package br.edu.ufam.agenda.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.controller.TarefaController;
import javax.swing.JButton;

public class DiaPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DiaPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPrximas = new JLabel("Neste dia");
		lblPrximas.setBounds(177, 25, 168, 34);
		panel_1.add(lblPrximas);
		add(panel_1);
		
		JList list = new JList();
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setBounds(0, 51, 450, 169);
		 listScrollPane.getViewport().setView(list);
		panel_1.add(listScrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 232, 404, 57);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JButton btnAtualizarLista = new JButton("Atualizar");
		btnAtualizarLista.setBounds(168, 12, 98, 25);
		panel.add(btnAtualizarLista);
		
		
		btnAtualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefaController tf = new TarefaController();
				List<AgendaPessoal> recebe = tf.pegaDia();
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return recebe.size();
					}
					public Object getElementAt(int index) {
						return recebe.get(index).getNomeTarefa()+" "+recebe.get(index).getDataTarefa();
					}
				});
			}
		});
		
		list.setModel(new AbstractListModel() {
			TarefaController tf = new TarefaController();
			List<AgendaPessoal> recebe = tf.pegaDia();
			public int getSize() {
				return recebe.size();
			}
			public Object getElementAt(int index) {
				return recebe.get(index).getNomeTarefa()+" "+recebe.get(index).getDataTarefa();
			}
		});
	}
}