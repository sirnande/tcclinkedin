package edu.br.utfpr.pdf;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Pdf {
	
	
	public static void main(String args[]) throws InterruptedException {
	
	 try{            
        // PdfReader pdfReader = new PdfReader(file);
         PdfReader pdfReader = new PdfReader("/home/melissa/dado_linkedin/RicardoCorassaProfile.pdf");
         PdfReader pdfReader1 = new PdfReader("/home/melissa/dado_linkedin/RobertaVivianeProfile.pdf");

         String s = "";
         //Extraindo de página em página e jogando numa String
         for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
             
             s = s.concat(PdfTextExtractor.getTextFromPage(pdfReader, i) + "\n\n");
             //Thread.currentThread();
			//Thread.sleep(100000);
         }
         
         FileWriter escritor = new FileWriter("/home/melissa/dado_linkedin/sirnande/teste.txt", true);
         BufferedWriter escritorbuffer = new BufferedWriter(escritor);

         escritorbuffer.write(s);
         escritorbuffer.newLine();
         escritorbuffer.flush();
         escritor.close();
         
         
         System.out.println("\n\n");
         String s1 = "";
         for (int i = 1; i <= pdfReader1.getNumberOfPages(); i++) {
             s1 = s1.concat(PdfTextExtractor.getTextFromPage(pdfReader1, i) + "\n\n");
             
         }
         
         FileWriter escritor1 = new FileWriter("/home/melissa/dado_linkedin/sirnande/teste1.txt", true);
         BufferedWriter escritorbuffer1 = new BufferedWriter(escritor1);

         escritorbuffer1.write(s);
         escritorbuffer1.newLine();
         escritorbuffer1.flush();
         escritor1.close();
        // System.out.println(s+"\n\n");
/*
         for (int i = 1; i <= pdfReader2.getNumberOfPages(); i++) {
             s = s.concat(PdfTextExtractor.getTextFromPage(pdfReader2, i) + "\n\n");
             if(i == 1){
                 nome = s;
             }
         }*/
         //mani.setTexto(s);
         System.out.println(s);
        } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
	}
}
