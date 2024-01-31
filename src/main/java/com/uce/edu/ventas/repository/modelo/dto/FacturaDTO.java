package com.uce.edu.ventas.repository.modelo.dto;

import java.time.LocalDateTime;

public class FacturaDTO {

	private String numero;
	private LocalDateTime fecha;
	
	//CONSTRUCTOR	
	public FacturaDTO(String numero, LocalDateTime fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
	}
	
	//GET Y SET
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	
	//TO STRING
	@Override
	public String toString() {
		return "FacturaDTO [numero=" + numero + ", fecha=" + fecha + "]";
	}
	
}
