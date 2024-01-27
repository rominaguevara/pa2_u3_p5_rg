package com.uce.edu.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.hotel.repository.IHotelRepository;
import com.uce.edu.hotel.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.actualizar(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.hotelRepository.eliminar(id);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelInnerJoin(nombre);
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelLeftJoin(direccion);
	}

	@Override
	public List<Hotel> buscarHotelRightJoin(String clase) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelRightJoin(clase);
	}

	@Override
	public List<Hotel> buscarHotelFulltJoin(String disponibilidad) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelFulltJoin(disponibilidad);
	}

}
