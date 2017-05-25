package br.edu.ufam.agenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class JanelaMain extends JFrame {

	private JPanel contentPane;

	private JPanel inicioPanel;
	private JPanel categoriaPanel;
	private JPanel diaPanel;
	private JPanel semanaPanel;
	private JPanel mesPanel;

	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMain frame = new JanelaMain();
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
	public JanelaMain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(38, 40, 445, 38);
		contentPane.add(panel);

		JButton button = new JButton("Dia");
		button.addActionListener(new ButtonDia());
		button.setBounds(197, 12, 57, 25);
		panel.add(button);

		JButton button_1 = new JButton("Mês");
		button_1.addActionListener(new ButtonMes());
		button_1.setBounds(338, 12, 77, 25);
		panel.add(button_1);

		JButton button_2 = new JButton("Categoria");
		button_2.addActionListener(new ButtonCategoria());
		button_2.setBounds(96, 12, 104, 25);
		panel.add(button_2);

		JButton button_3 = new JButton("Início");
		button_3.addActionListener(new ButtonInicio());
		button_3.setBounds(12, 12, 91, 25);
		panel.add(button_3);

		JButton button_4 = new JButton("Semana");
		button_4.addActionListener(new ButtonSemana());
		button_4.setBounds(254, 12, 91, 25);
		panel.add(button_4);

		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(38, 102, 455, 380);
		contentPane.add(panel_1);

		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setBounds(222, 22, 111, 27);
		contentPane.add(lblAtividades);
		
		
		
		// Inicia os Panels de categoria, mes, inicio, semana.
		iniciaPanels();
	}

	void iniciaPanels(){
		inicioPanel = new InicioPanel();
		categoriaPanel = new CategoriaPanel();
		diaPanel = new DiaPanel();
		mesPanel = new MesPanel();
		semanaPanel = new SemanaPanel();
		panel_1.add(inicioPanel);
		
	}
	
	private class ButtonInicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			panel_1.removeAll();
			panel_1.add(inicioPanel);
			panel_1.updateUI();
		}
	}
	
	private class ButtonMes implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			panel_1.removeAll();
			panel_1.add(mesPanel);
			panel_1.updateUI();
		}
	}
	
	private class ButtonSemana implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			panel_1.removeAll();
			panel_1.add(semanaPanel);
			panel_1.updateUI();
		}
	}
	
	private class ButtonDia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			panel_1.removeAll();
			panel_1.add(diaPanel);
			panel_1.updateUI();
		}
	}
	
	private class ButtonCategoria implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			panel_1.removeAll();
			panel_1.add(categoriaPanel);
			panel_1.updateUI();
		}
	}
	
	
	
	
	
}
