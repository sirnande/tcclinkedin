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
public class Educacao {
    
    private String local;
    private String area;
    private String data_inicio;
    private String data_termino;
    
    Educacao(){}
    
    public Educacao(String local, String area, String data_inicio, String data_termino) {
        this.local = local;
        this.area = area;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
    }
    
    

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
		return "Educacao [local=" + local + ", area=" + area + ", data_inicio=" + data_inicio + ", data_termino="
				+ data_termino + "]";
	}
    
    
}
