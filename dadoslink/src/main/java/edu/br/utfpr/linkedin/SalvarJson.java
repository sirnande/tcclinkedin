package edu.br.utfpr.linkedin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.br.utfpr.processo.*;

public class SalvarJson {
	
	 private  File diretorio = new File("/home/melissa/dados_linkedin/sirnande");
	 
	 private  File arquivo = new File(diretorio, "linkedin.json");
	 private  FileReader leitor;
	 private  BufferedReader leitorbuffer;
	 private Log log;
	 
	 SalvarJson(){
		 try {
	         arquivo.createNewFile();
	         
	     } catch (IOException ex) {
	         Logger.getLogger(ArquivoLeGrava.class.getName()).log(Level.SEVERE, null, ex);
	         Log.log("Erro ao criar arquivo linkedin.json "+ex);
	     }
	 }
	
	public boolean gravar(List<String> json) {
		
		try {
			//Escreve Json convertido em arquivo chamado "file.json"
			//FileWriter writer = new FileWriter("/home/melissa/dado_linkedin/sirnande/linkedin.json");
			//writer.write(json);
			//writer.close();
			//return true;
			boolean flush;
			
			
			 for (int i = 0; i < json.size(); i++) {
	                if (i == 0) {
	                    flush = false;
	                } else {
	                    flush = true;
	                }
	                FileWriter escritor = new FileWriter(arquivo, flush);
	                BufferedWriter escritorbuffer = new BufferedWriter(escritor);

	                escritorbuffer.write(json.get(i));
	                escritorbuffer.newLine();
	                escritorbuffer.flush();
	                escritor.close();

	            }
			 
			 return true;
	 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<String> lerJson(){
			
		try {
			List<String> clientes = new ArrayList<String>();
			
	        leitor = new FileReader(arquivo);
	        leitorbuffer = new BufferedReader(leitor);
	

	        while (leitorbuffer.ready()) {
	            StringBuilder aux = new StringBuilder();
	            aux.append(leitorbuffer.readLine());
	            clientes.add(aux.toString());
	            
	        }
	        
	        return clientes;
		}catch(Exception ex) {
			System.out.println("Erro ao ler o arquivo .json "+ex);
			log.log("Erro ao ler o arquivo .json "+ex);
		}
		
		return null;
	}

}



