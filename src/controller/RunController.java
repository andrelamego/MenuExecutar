package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RunController implements ActionListener {
	
	private JTextField fieldExecutar;
	private JFrame frame;
	
	public RunController(JTextField fieldExecutar, JFrame frame) {
		super();
		this.fieldExecutar = fieldExecutar;
		this.frame = frame;
	}
	
	private void runCmd() {
		String cmd = fieldExecutar.getText();
		String[] splitCmd = cmd.split(" ");
		
		try {
			
			frame.dispose();
			
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
	}
}
