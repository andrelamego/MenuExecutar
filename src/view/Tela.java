package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.RunController;
import controller.SearchController;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldExecutar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Digite o caminho do executável ou clique em procurar.");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(79, 21, 305, 14);
		contentPane.add(lblTitulo);
		
		fieldExecutar = new JTextField();
		fieldExecutar.setBounds(76, 86, 305, 20);
		contentPane.add(fieldExecutar);
		fieldExecutar.setColumns(10);
		
		JLabel lblAbrir = new JLabel("Abrir: ");
		lblAbrir.setBounds(20, 89, 46, 14);
		contentPane.add(lblAbrir);
		
		JButton btnProcurar = new JButton("Procurar...");
		btnProcurar.setBackground(new Color(221, 221, 221));
		btnProcurar.setBounds(289, 147, 95, 23);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela.this.dispose();
			}
		});
		btnCancelar.setBackground(new Color(221, 221, 221));
		btnCancelar.setBounds(191, 147, 95, 23);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(221, 221, 221));
		btnOk.setBounds(93, 147, 95, 23);
		contentPane.add(btnOk);
		
		JLabel iconLabel = new JLabel("New label");
		iconLabel.setIcon(new ImageIcon(Tela.class.getResource("/view/icon.png")));
		iconLabel.setBounds(5, 14, 64, 64);
		contentPane.add(iconLabel);
		validate();
		
		
		RunController run = new RunController(fieldExecutar);
		btnOk.addActionListener(run);
		
		SearchController search = new SearchController(fieldExecutar);
		btnProcurar.addActionListener(search);
		
	}
}
