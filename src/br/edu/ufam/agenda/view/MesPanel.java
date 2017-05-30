package br.edu.ufam.agenda.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.controller.TarefaController;

public class MesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MesPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		
		add(panel_1);

		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPrximas = new JLabel("Mês");
		GridBagConstraints gbc_lblPrximas = new GridBagConstraints();
		gbc_lblPrximas.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrximas.gridx = 0;
		gbc_lblPrximas.gridy = 0;
		panel_1.add(lblPrximas, gbc_lblPrximas);
		add(panel_1);
		
		JList list = new JList();
		JScrollPane listScrollPane = new JScrollPane();
		 listScrollPane.setSize(new Dimension(75,200));
		 listScrollPane.getViewport().setView(list);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		panel_1.add(listScrollPane, gbc_list);
		
		TarefaController tf = new TarefaController();
		List<AgendaPessoal> recebe = tf.pegaMes();
		
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe.size();
			}
			public Object getElementAt(int index) {
				return recebe.get(index).getNomeTarefa()+" "+recebe.get(index).getDataTarefa();
			}
		});
	}

}