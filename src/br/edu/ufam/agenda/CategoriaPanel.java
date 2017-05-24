package br.edu.ufam.agenda;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class CategoriaPanel extends JPanel {
	java.util.List<String> recebe;
	
	
	/**
	 * Create the panel.
	 */
	public CategoriaPanel() {
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
		
		
		
		DefaultListModel model=new DefaultListModel();
//
		JScrollPane scrollPane = new JScrollPane();
//		
//		scrollPane.setViewportView(list);
//		list.setLayoutOrientation(JList.VERTICAL);
//		list.setModel(new AbstractListModel() {
//			public int getSize() {
//				return recebe.size();
//			}
//			public Object getElementAt(int index) {
//				return recebe;
//			}
//		});
//		panel_1.add(list, gbc_list);
//		panel_1.add(scrollPane);
//		
//		int n = recebe.size();
//	    for (int i=0; i<n; i++) {
//	      System.out.printf("Posição %d- %s\n", i, recebe.get(i));
//	    }
//		
////		 for (AgendaPessoal tarefas : recebe) {
////		 System.out.println(tarefas.getNomeTarefa());
////		 }

	}
}
