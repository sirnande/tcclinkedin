/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.br.utfpr.linkedin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 *
 * @author melissa
 */
public class Main {
    public static void main(String args[]){
        
        List<Pessoa> nova = null;
        List<Educacao> edu = null;// = new List<Educacao>();
        List<Experiencia> exp = null;
        List<String> pessoa = new ArrayList<String>();
        
        nova = new ArrayList<Pessoa>();
        edu = new ArrayList<Educacao>();
        exp = new ArrayList<Experiencia>();
        
        System.out.println("\nCriando Educacao");
        edu.add(new Educacao("Forlogic", "Desenvolvedor", "07/2017", "ate o presente"));
        edu.add(new Educacao("CDS", "Desenvolvedor", "07/2017", "ate o presente"));
        edu.add(new Educacao("ATOS", "Desenvolvedor", "07/2017", "ate o presente"));
        
        System.out.println("\nCriando experiencia");
        exp.add(new Experiencia("UTFPR", "aluno", "07/2017", "ate o presente"));
        exp.add(new Experiencia("Colegio Santa Mariana", "Aluno", "07/2017", "ate o presente"));
        exp.add(new Experiencia("CBD ursos profissionalisante", "Aluno", "07/2017", "ate o presente"));
        
        
        Gson gson = new Gson();
        
        System.out.println("\nCriando json");
        Pessoa pes = new Pessoa("Joa Maria", "Analista", "google.com", null, exp, edu);
        Pessoa pes1 = new Pessoa("Andre Maia", "Desenvolvedor", "utfpr@.com", null, exp, edu);
        Pessoa pes2 = new Pessoa("Ana Paula", "Programador", "fab@com.com", null, exp, edu);
        Pessoa pes3 = new Pessoa("Sirnande", "Analista", "google.com", null, exp, edu);
        
        System.out.println(pes.toString());
        
        pessoa.add(gson.toJson(pes));
        pessoa.add(gson.toJson(pes1));
        pessoa.add(gson.toJson(pes2));
        pessoa.add(gson.toJson(pes3));
        
        
        System.out.println("\nGravando json");
        
        SalvarJson gravar = new SalvarJson();
        
        gravar.gravar(pessoa);
        
        System.out.println("\n***************************************************\n");

        System.out.println("\nconvertendo de json para objeto");
        
        List<String> string = new ArrayList<String>();
        List<Pessoa> person = new ArrayList<Pessoa>();
        
        string = gravar.lerJson();
        Pessoa people = new Pessoa();
        
        for(String json : string) {
        	people = gson.fromJson(json, Pessoa.class);
        	person.add(people);
        	System.out.println(people.toString());
        }
        
        System.out.println("Finish....");
    }        
    
}
