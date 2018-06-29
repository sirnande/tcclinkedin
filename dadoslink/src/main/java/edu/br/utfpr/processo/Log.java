package edu.br.utfpr.processo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import edu.br.utfpr.linkedin.Pessoa;

public class Log {
	
	public static File diretorio;// = new File(home,"/logSystem");
	public static File arquivo;
	
	public static void log(String erro) {
		
		DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate data = LocalDate.parse("23062017", parserData);
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatterData.format(data); // 23/06/2017
		dataFormatada = dataFormatada.replaceAll("/", "");
		String log = dataFormatada+".txt";
		
		String home = System.getProperty("user.home");
		
		diretorio = new File(home,"/logSystem");
		arquivo = new File(diretorio, log);
		
		try {
			if(!diretorio.exists()) {
				diretorio.mkdirs();
			}
			
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			System.out.println("Criado com sucesso .....");
		}catch(Exception ex) {
			System.err.println("Erro ao cria arquivo"+ ex);
		}
		
		System.out.println(home + " "+log);
		try {
			gravar(erro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void gravar(String log) throws IOException {
        //boolean flush;
        FileWriter escritor = new FileWriter(arquivo, true);
        BufferedWriter escritorbuffer = new BufferedWriter(escritor);

        escritorbuffer.write(log);
        escritorbuffer.newLine();
        escritorbuffer.flush();
        escritor.close();

    }

}
