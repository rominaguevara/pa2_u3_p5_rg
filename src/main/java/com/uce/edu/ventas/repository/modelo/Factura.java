package com.uce.edu.ventas.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura")
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura",allocationSize = 1)
	@Column(name ="fact_id")
	private Integer id;
	
	@Column(name ="fact_numero")
	private String numero;
	
	@Column(name ="fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name ="fact_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//FetchType.EAGER hace que SIEMPRE traiga toda la información de la relación si la tuviese la necesite o no
																					   //FetchType.LAZY NUNCA va a traer la información de la relación, trae la información cuando tiene la señal
																					   //EAGER ocupa más recursos, por que hace así no se necesite , mejor es usar LAZY POR QUE ES MAS EFICIENTE pero especificando la demanda que necesita, eso se hace en el Query, por eso el default es el Lazy pero si no se pone la señal ahí si da error
	private List<DetalleFactura> detalleFactura;

	
	//TO STRING
	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedula=" + cedula
				+ ", detalleFactura=" + detalleFactura + "]";
	}	

	//GET Y SET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}
	
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
