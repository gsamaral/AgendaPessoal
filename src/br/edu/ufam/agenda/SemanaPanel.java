package br.edu.ufam.agenda;

import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class SemanaPanel extends JPanel {
//	SELECT * FROM TAREFA WHERE dataTarefa BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW();
	java.util.List<AgendaPessoal> recebe;
	/**
	 * Create the panel.
	 */
	public SemanaPanel() {
		
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
		panel_1.add(list, gbc_list);
		
		TarefaController tf = new TarefaController();
		recebe  = tf.pegaSemana();
		DefaultListModel model=new DefaultListModel();

		
		JPanel panel = new JPanel();
		
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
