package br.edu.ufam.agenda.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import br.edu.ufam.agenda.Categoria;
import br.edu.ufam.agenda.controller.CategoriaController;
import br.edu.ufam.agenda.controller.TarefaController;

public class EditarCat extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCat frame = new EditarCat();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public EditarCat(){
		
	}
	
	public EditarCat(Categoria cat) {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 6, 390, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNovaAtividade = new JLabel("Editar ");
		lblNovaAtividade.setFont(new Font("Liberation Mono", Font.BOLD, 14));
		lblNovaAtividade.setBounds(84, 12, 127, 24);
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
		
		ButtonGroup btgroup = new ButtonGroup();
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 102, 390, 48);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		
		JButton btnOk = new JButton("ok");
		btnOk.setBounds(101, 23, 62, 25);
		panel_2.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CategoriaController ct = new CategoriaController();
				
				
				try {
					ct.alterarCat(cat.getId(), textField.getText());
					JOptionPane.showMessageDialog(null, "Categoria foi editada. Clique pra atualizar lista");
					System.out.println(cat.getId());
					System.out.println(textField.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
	}
}
