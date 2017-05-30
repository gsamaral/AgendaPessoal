package br.edu.ufam.agenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import br.edu.ufam.agenda.AgendaPessoal;
import br.edu.ufam.agenda.controller.CategoriaController;
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

public class ExcAtividade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ExcAtividade frame = new ExcAtividade();
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
	public ExcAtividade() {
		// TODO Auto-generated constructor stub
	}

	public ExcAtividade(AgendaPessoal tarefa) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(5, 6, 390, 33);
		JLabel lblDesejaRealmenteExcluir = new JLabel("Deseja realmente excluir?");
		lblDesejaRealmenteExcluir.setBounds(45, 53, 299, 15);
		panel.add(lblDesejaRealmenteExcluir);
		contentPane.add(panel);

		JButton btnSim = new JButton("sim");
		btnSim.setBounds(85, 97, 117, 25);

		JButton btnNo = new JButton("não");
		btnNo.setBounds(224, 97, 117, 25);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 51, 390, 72);
		contentPane.add(panel_1);

		panel_1.add(btnSim);
		panel_1.add(btnNo);

		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TarefaController ct = new TarefaController();

				try {
					ct.excluirTarefa(tarefa.getId());

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

}
