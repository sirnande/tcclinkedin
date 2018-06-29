/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.br.utfpr.linkedin;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author melissa
 */
//@Entity
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
    
    private String cargo;
    
    private String email;
    
    private String sumario;    
    private List<Experiencia> experiencia;
    private List<Educacao> educacao;
    
    public Pessoa(){}

    public Pessoa(String nome, String cargo, String email, String sumario, List<Experiencia> experiencia, List<Educacao> educacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.sumario = sumario;
        this.experiencia = experiencia;
        this.educacao = educacao;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public List<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public List<Educacao> getEducacao() {
        return educacao;
    }

    public void setEducacao(List<Educacao> educacao) {
        this.educacao = educacao;
    }

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cargo=" + cargo + ", email=" + email + ", sumario=" + sumario
				+ ", experiencia=" + experiencia + ", educacao=" + educacao + "]";
	}
    
    
    
}
