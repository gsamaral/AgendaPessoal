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
import java.awt.Panel;

public class MesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MesPanel() {
		java.util.List<AgendaPessoal> recebe;
		
		
		
		
		TarefaController tf = new TarefaController();
		recebe  = tf.pegaMes();		
//		 JScrollPane listScrollPane = new JScrollPane();
//		 listScrollPane.setSize(new Dimension(75,200));
//		 listScrollPane.getViewport().setView(list);
		
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(52, 79, 445, 300);
		 add(panel);
//		 GridBagLayout gbl_panel = new GridBagLayout();
//		 gbl_panel.columnWidths = new int[]{0, 0};
//		 gbl_panel.rowHeights = new int[]{0, 0};
//		 gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		 gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
//		 panel.setLayout(gbl_panel);
//		 
		 JList list_1 = new JList();
//		 JScrollPane listScrollPane = new JScrollPane();
//		 listScrollPane.setSize(new Dimension(75,200));
//		 listScrollPane.getViewport().setView(list_1);
//		 GridBagConstraints gbc_list_1 = new GridBagConstraints();
//		 gbc_list_1.fill = GridBagConstraints.BOTH;
//		 gbc_list_1.gridx = 0;
//		 gbc_list_1.gridy = 0;
//		 panel.add(listScrollPane, gbc_list_1);
		 
		 list_1.setBounds(82, 92, 294, 200);
			list_1.setModel(new AbstractListModel() {
				public int getSize() {
					return recebe.size();
				}
				public Object getElementAt(int index) {
					return recebe.get(index).getNomeTarefa()+" "+recebe.get(index).getDataTarefa();
				}
			});
		
panel.add(list_1);
	}
}
