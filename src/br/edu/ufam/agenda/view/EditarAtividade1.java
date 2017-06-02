package br.edu.ufam.agenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.controller.TarefaController;

import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class EditarAtividade1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					EditarAtividade1 frame= new EditarAtividade1();
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
	public EditarAtividade1(){
		
	}
	
	
	public EditarAtividade1(AgendaPessoal tarefa) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 6, 390, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNovaAtividade = new JLabel("Editar Atividade");
		lblNovaAtividade.setFont(new Font("Liberation Mono", Font.BOLD, 14));
		lblNovaAtividade.setBounds(133, 12, 140, 24);
		panel.add(lblNovaAtividade);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 51, 390, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(70, 12, 191, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 9, 127, 24);
		panel_1.add(lblNome);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(12, 45, 70, 15);
		panel_1.add(lblCategoria);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Reunião", "Escolar", "Profissional", "Outros"}));
		comboBox_1.setBounds(100, 42, 161, 20);
		panel_1.add(comboBox_1);
		
		ButtonGroup btgroup = new ButtonGroup();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 102, 390, 48);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(12, 27, 70, 15);
		panel_2.add(lblData);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(96, 23, 118, 19);
		panel_2.add(dateChooser);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(5, 150, 390, 36);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblAlarme = new JLabel("Alarme");
		lblAlarme.setBounds(12, 12, 70, 15);
		panel_4.add(lblAlarme);
		
		JSpinField spinField = new JSpinField();
		spinField.setBounds(100, 8, 45, 19);
		panel_4.add(spinField);
		
		JSpinField spinField_1 = new JSpinField();
		spinField_1.setBounds(157, 8, 45, 19);
		panel_4.add(spinField_1);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(5, 184, 390, 48);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ativa", "Concluída", "Planejamento"}));
		comboBox.setBounds(92, 7, 134, 24);
		panel_5.add(comboBox);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(12, 12, 70, 15);
		panel_5.add(lblStatus);
		
		
		
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefaController tc = new TarefaController();
				int hora = spinField.getValue();
				int minuto = spinField_1.getValue();
				
				String categoria = comboBox_1.getSelectedItem().toString();
				try {
					tc.alterarTarefa(tarefa.getId(), textField.getText(), categoria, comboBox.getSelectedItem().toString(), dateChooser.getDate(),hora,minuto);
					JOptionPane.showMessageDialog(null, "Atividade editada");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBounds(152, 258, 62, 25);
		contentPane.add(btnOk);
	}
}
