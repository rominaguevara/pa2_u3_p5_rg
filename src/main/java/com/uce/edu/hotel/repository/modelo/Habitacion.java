package com.uce.edu.hotel.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habitacion")
	@SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion", allocationSize = 1)
	@Column(name = "habi_id")
	private Integer id;

	@Column(name = "habi_numero")
	private String numero;

	@Column(name = "habi_clase")
	private String clase;
	
	@Column(name = "habi_disponibilidad")
	private String disponibilidad;

	@ManyToOne (cascade = CascadeType.ALL) //la relación de habitación hotel es de muchas habitaciones a un hotel
	@JoinColumn(name = "habi_id_hotel")
	private Hotel hotel;

	//TO STRING	
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero + ", clase=" + clase  + "]";
	}

	// GET y SET
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

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
