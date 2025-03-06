package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.Tela;

public class RunController implements ActionListener {
	
	private JTextField fieldExecutar;
	
	public RunController(JTextField fieldExecutar) {
		super();
		this.fieldExecutar = fieldExecutar;
	}
	
	private void runCmd() {
		String cmd = fieldExecutar.getText();
		String[] splitCmd = cmd.split(" ");
		
		try {
			
			Process p = Runtime.getRuntime().exec(splitCmd);
			
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			
			String linha = buffer.readLine();
			
			while (linha != null) {				
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			reader.close();
			stream.close();
			
		} catch (Exception error) {
			String erro = error.getMessage();
			System.err.println(erro);
			JOptionPane.showMessageDialog(null, "Arquivo inválido", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		runCmd();
		Tela tela = new Tela();
		tela.dispose();
	}
}
