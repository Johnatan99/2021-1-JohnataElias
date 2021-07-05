package atividade_1;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Classe {
	
	private static String local;
	
    public static void main(String[] args) {
        
    	JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= file.showSaveDialog(null);
      if (i==1){
    	  local = " ";
      } else {
          File arquivo = file.getSelectedFile();
          local = arquivo.getPath();
      }
      System.out.println(local);
      
     
    	
    }
}
