package br.edu.ufam.agenda;

import javax.swing.JPanel;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InicioPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InicioPanel() {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		add(panel);
		
		JLabel lblPrximas = new JLabel("Próximas");
		lblPrximas.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblPrximas);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		panel_2.add(list, gbc_list);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JList list_1 = new JList();
		
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		panel_3.add(list_1, gbc_list_1);
		TarefaController tf = new TarefaController();
		List<AgendaPessoal> recebe2 = tf.statusConcluido();
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe2.size();
			}
			public Object getElementAt(int index) {
				return recebe2.get(index).getNomeTarefa()+" "+recebe2.get(index).getDataTarefa();
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		
		List<AgendaPessoal> recebe = tf.listaTarefas();
		DefaultListModel model=new DefaultListModel();
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
