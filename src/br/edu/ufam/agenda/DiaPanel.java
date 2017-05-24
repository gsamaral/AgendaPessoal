package br.edu.ufam.agenda;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class DiaPanel extends JPanel {
	java.util.List<AgendaPessoal> recebe;
	/**
	 * Create the panel.
	 */
	public DiaPanel() {
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 102, 426, 131);
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		
		
		TarefaController tf = new TarefaController();
		recebe  = tf.pegaDia();
		DefaultListModel model=new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(75,200));
		scrollPane.getViewport().setView(list);
		
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe.size();
			}
			public Object getElementAt(int index) {
				return recebe.get(index).getNomeTarefa()+" "+recebe.get(index).getDataTarefa();
			}
		});
		panel_1.add(list, gbc_list);
		panel_1.add(scrollPane);
		

	}

}
