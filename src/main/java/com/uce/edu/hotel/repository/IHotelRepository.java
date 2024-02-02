package com.uce.edu.hotel.repository;

import java.util.List;

import com.uce.edu.hotel.repository.modelo.Hotel;

public interface IHotelRepository {

	// CRUD
	public void insertar(Hotel hotel);

	public Hotel seleccionar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	public List<Hotel> seleccionarHotelInnerJoin(String nombre);
	
	public List<Hotel> seleccionarHotelLeftJoin(String direccion);

	public List<Hotel> seleccionarHotelRightJoin(String clase);
	
	public List<Hotel> seleccionarHotelFulltJoin(String disponibilidad);
		
}
