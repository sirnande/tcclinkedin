package edu.br.utfpr.linkedin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author fabricio@utfpr.edu.br
 */
public class ArquivoLeGrava {

    private static String arquiv;
    private static File diretorio = new File("/home/melissa/dado_linkedin/sirnande/");//null;//new File("C:\\sirnande");
    private static File arquivo = new File(diretorio, "cliente.txt");
    private static File arquivo2 = new File(diretorio, "cadastro.obj");
    private static FileReader leitor;
    private static BufferedReader leitorbuffer;


    public ArquivoLeGrava() {
       // verificar();

        try {
            arquivo.createNewFile();
            arquivo2.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoLeGrava.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void verificar(){
        String SO = System.getProperty("os.name");
        SO = "Linux";
        if(SO.compareTo("Linux") == 0){
            System.out.println("linux ");
            diretorio = new File("/home/melissa/dado_linkedin/sirnande");
            if(!diretorio.exists()){
                diretorio.mkdir();
            }
        }else{
            System.out.println("outros ");
            diretorio = new File("C:\\sirnande");
            if(!diretorio.exists()){
                diretorio.mkdir();
            }
        }
    }


    public static void gravar(List<Pessoa> clientes, boolean cond) throws IOException {
        boolean flush;
        if (cond) {
            for (int i = 0; i < clientes.size(); i++) {
                if (i == 0) {
                    flush = false;
                } else {
                    flush = true;
                }
                FileWriter escritor = new FileWriter(arquivo, true);
                BufferedWriter escritorbuffer = new BufferedWriter(escritor);

                escritorbuffer.write(clientes.get(i).toString());
                escritorbuffer.newLine();
                escritorbuffer.flush();
                escritor.close();

            }
        } else {
            try (FileOutputStream fos = new FileOutputStream(arquivo2, false)) {
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(clientes);
                fos.flush();
            }
        }

    }
/*
    public static ArrayList<Pessoa> LeTexto(boolean cond) throws IOException, ClassNotFoundException {
        ArrayList<Pessoa> clientes = new ArrayList<>();
        if (cond) {
            leitor = new FileReader(arquivo);
            leitorbuffer = new BufferedReader(leitor);

            int k;//= 0;
            Pessoa cl1;
            while (leitorbuffer.ready()) {
                StringBuilder aux = new StringBuilder();
                aux.append(leitorbuffer.readLine());
                cl1 = new Cliente(
                        aux.substring(0, (k = aux.indexOf(";"))),
                        Integer.parseInt((aux.substring(k + 1, (k = aux.indexOf(";", k + 1))))),
                        aux.substring(k + 1, (k = aux.indexOf(";", k + 1))),
                        aux.substring(k + 1, (k = aux.indexOf(";", k + 1))),
                        Float.parseFloat((aux.substring(k + 1, (k = aux.indexOf(";", k + 1))))),
                        Float.parseFloat((aux.substring(k + 1, (k = aux.indexOf(";", k + 1)))))
                );

                clientes.add(cl1);
            }
        } else {
            
            ObjectInputStream recebeArquivo = null;
            
            FileInputStream ler = new FileInputStream(arquivo2);

            recebeArquivo = new ObjectInputStream(ler);

            Object recebeDados = recebeArquivo.readObject();
            return (ArrayList<Cliente>) recebeDados;
        }

        return clientes;
    }*/

}
