package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		ImageIcon imgNovaAtividade = new ImageIcon("/home/geovana/Documentos/eclipse/AgendaPessoal/img/newtask.png");
		ImageIcon editIcon = new ImageIcon("/home/geovana/Documentos/eclipse/AgendaPessoal/img/edit.png");
		ImageIcon findIcon = new ImageIcon("/home/geovana/Documentos/eclipse/AgendaPessoal/img/find.png");
		JButton btnNewButton = new JButton(imgNovaAtividade);
		btnNewButton.setBounds(49, 88, 134, 108);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton(editIcon);
		btnNewButton_1.setBounds(244, 88, 134, 108);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		JButton btnExibirAtividades = new JButton(findIcon);
		btnExibirAtividades.setBounds(49, 225, 134, 108);
		contentPane.add(btnExibirAtividades);
		ImageIcon deleteIcon = new ImageIcon("/home/geovana/Documentos/eclipse/AgendaPessoal/img/delete.png");
		JButton btnRemover = new JButton(deleteIcon);
		btnRemover.setBounds(244, 225, 134, 108);
		contentPane.add(btnRemover);
		//
		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setBounds(155, 34, 134, 24);
		contentPane.add(lblAgendaPessoal);
	}
}
