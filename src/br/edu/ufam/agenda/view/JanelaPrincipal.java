package br.edu.ufam.agenda.view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.controller.TarefaController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Insets;


public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		textField = new JTextField();
//		textField.setBounds(225, 343, 114, 19);
//		contentPane.add(textField);
//		textField.setColumns(10);
		
//		JButton btnNewButton = new JButton("New button");
//		
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				NovaAtividade edit = new NovaAtividade();
//				edit.setVisible(true);
//				
////				TarefaController tf = new TarefaController();
////				List<AgendaPessoal> lista = tf.listaTarefas();
////				textField.setText(lista.get(0).getNomeTarefa());
//				
//			}
//		});
//		btnNewButton.setBounds(83, 334, 117, 37);
//		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 88, 385, 128);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPrximas = new JLabel("Próximas");
		GridBagConstraints gbc_lblPrximas = new GridBagConstraints();
		gbc_lblPrximas.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrximas.gridx = 0;
		gbc_lblPrximas.gridy = 0;
		panel_1.add(lblPrximas, gbc_lblPrximas);
		
		
		
		JList list = new JList();
		JScrollPane listScrollPane = new JScrollPane();
		 listScrollPane.setSize(new Dimension(75,200));
		 listScrollPane.getViewport().setView(list);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		panel_1.add(listScrollPane, gbc_list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(51, 230, 385, 128);
		contentPane.add(panel_2);
		
		JLabel lblConcludas = new JLabel("Concluídas");
		GridBagConstraints gbc_lblConcludas = new GridBagConstraints();
		gbc_lblConcludas.insets = new Insets(0, 0, 5, 0);
		gbc_lblConcludas.gridx = 0;
		gbc_lblConcludas.gridy = 0;
		panel_2.add(lblConcludas, gbc_lblConcludas);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 38, 445, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDia = new JButton("Dia");
		btnDia.setBounds(197, 12, 57, 25);
		btnDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(new DiaPanel());
				panel_1.updateUI();
				panel_2.updateUI();
				panel_2.removeAll();
			}
		});
		panel.add(btnDia);
		
		JButton btnMs = new JButton("Mês");
		btnMs.setBounds(338, 12, 77, 25);
		panel.add(btnMs);
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(new MesPanel());
				panel_1.updateUI();
				panel_2.updateUI();
				panel_2.removeAll();
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Categoria");
		btnNewButton_1.setBounds(96, 12, 104, 25);
		panel.add(btnNewButton_1);
		
		JButton btnIncio = new JButton("Início");
		btnIncio.setBounds(12, 12, 91, 25);
		panel.add(btnIncio);
		
		
		
		JButton btnSemana = new JButton("Semana");
		btnSemana.setBounds(254, 12, 91, 25);
		panel.add(btnSemana);
		btnSemana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(new SemanaPanel());
				panel_1.updateUI();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_2.removeAll();
				panel_1.add(new CategoriaPanel());
				panel_1.updateUI();
				panel_2.updateUI();
			}
		});
//		
		btnIncio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_2.removeAll();
				panel_1.add(new InicioPanel());
				panel_1.updateUI();
				panel_2.updateUI();
				
				
			}
		});
		
		
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAtividades.setBounds(174, 22, 97, 15);
		contentPane.add(lblAtividades);
		
		
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JList list_1 = new JList();
		JScrollPane listScrollPane2 = new JScrollPane();
		 listScrollPane2.setSize(new Dimension(75,200));
		 listScrollPane2.getViewport().setView(list_1);
		
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 2;
		panel_2.add(listScrollPane2, gbc_list_1);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon("/home/geovana/Documentos/eclipse/AgendaPessoal/img/Pencil-icon.png"));
		btnEditar.setBounds(159, 411, 46, 30);
		contentPane.add(btnEditar);
		
		
		
		
		
		
		JButton btnMais = new JButton("");
		btnMais.setIcon(new ImageIcon("/home/geovana/Documentos/eclipse/AgendaPessoal/img/add-1-icon.png"));
		btnMais.setBounds(220, 411, 51, 30);
		contentPane.add(btnMais);
		
		
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaAtividade novaAtv = new NovaAtividade();
				novaAtv.setVisible(true);
//				TarefaController tf = new TarefaController();
//				List<AgendaPessoal> lista = tf.listaTarefas();
//				textField.setText(lista.get(0).getNomeTarefa());
				
			}
		});
		
//		btnIncio.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				panel.add(panel_1);
//				
//			}
//		});
		
		TarefaController tf = new TarefaController();
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
		
	
		List<AgendaPessoal> recebe2 = tf.statusConcluido();
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return recebe2.size();
			}
			public Object getElementAt(int index) {
				return recebe2.get(index).getNomeTarefa()+" "+recebe2.get(index).getDataTarefa();
			}
			
		});
		
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefaController edit = new TarefaController();
				
				String item = (String) list.getSelectedValue();
				String[] itemLista = item.split(" ");
				String s = itemLista[0].toString();
				
				
			try {
				EditarAtividade1 editTarefa = new EditarAtividade1(edit.buscaContatoPorNome(s));
				editTarefa.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//				TarefaController tf = new TarefaController();
//				List<AgendaPessoal> lista = tf.listaTarefas();
//				textField.setText(lista.get(0).getNomeTarefa());
				
			}
		});
//		
//		String item = (String) list.getSelectedValue();
//		String[] itemLista = item.split(" ");
//		System.out.println(itemLista[0]);
//		 
		
		//TODO USAR SPLIT NA STRING DA LISTA  E PASSA LA NA FUNCAO DE BUSCA POR NOME E SETAR OS VALORES NOS CAMPOS
		
		
		
		
		
	}
}
