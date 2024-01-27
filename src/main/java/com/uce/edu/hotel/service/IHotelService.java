package com.uce.edu.hotel.service;

import java.util.List;

import com.uce.edu.hotel.repository.modelo.Hotel;

public interface IHotelService {

	// CRUD
	public void guardar(Hotel hotel);

	public Hotel buscar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);
	
	public List<Hotel> buscarHotelInnerJoin(String nombre);
	
	public List<Hotel> buscarHotelLeftJoin(String direccion);
	
	public List<Hotel> buscarHotelRightJoin(String clase);
	
	public List<Hotel> buscarHotelFulltJoin(String disponibilidad);
}
