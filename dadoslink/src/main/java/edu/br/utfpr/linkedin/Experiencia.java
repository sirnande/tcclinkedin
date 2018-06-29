/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.br.utfpr.linkedin;

/**
 *
 * @author melissa
 */
public class Experiencia {
    
    private String cargo;
    private String local;
    private String data_inicio;
    private String data_termino;
    
    public Experiencia(String local, String cargo, String data_inicio, String data_termino){
  
        this.cargo = cargo;
        this.local = local;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

	@Override
	public String toString() {
		return "Experiencia [cargo=" + cargo + ", local=" + local + ", data_inicio=" + data_inicio + ", data_termino="
				+ data_termino + "]";
	}
    
    
    
}
