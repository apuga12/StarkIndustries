package com.starkindustries.springapp.domain;

import java.io.Serializable;

public class Product1_SinPersistencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private Double precio;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Descripcion => " + descripcion + ";");
        buffer.append("Precio => " + precio);
        return buffer.toString();
    }
	
}
