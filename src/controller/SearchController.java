package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchController implements ActionListener {
	
	private JTextField fieldExecutar;

	public SearchController(JTextField fieldExecutar) {
		super();
		this.fieldExecutar = fieldExecutar;
	}

	private void searchFile() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquios Executáveis (.exe)", "exe");
		String dirBase = System.getProperty("user.home")+ "/Onedrive/Área de Trabalho" ;
		File dir = new File(dirBase);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(dir);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(filtro);
		String caminho = "";
		
		int retorno = chooser.showOpenDialog(null);
		if(retorno == JFileChooser.APPROVE_OPTION) {
			caminho = chooser.getSelectedFile().getAbsolutePath();
			fieldExecutar.setText(caminho);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		searchFile();
	}

}
