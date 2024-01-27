package com.uce.edu.hotel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.hotel.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.seleccionar(id);
		this.entityManager.remove(hotel);
	}

	@Override
	public List<Hotel> seleccionarHotelInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones WHERE h.nombre = :nombre", Hotel.class);
		myQuery.setParameter("nombre", nombre);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones WHERE h.direccion = :direccion", Hotel.class);
		myQuery.setParameter("direccion", direccion);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}
	
	@Override
	public List<Hotel> seleccionarHotelRightJoin(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones hab WHERE hab.clase = :clase", Hotel.class);
		myQuery.setParameter("clase", clase);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelFulltJoin(String disponibilidad) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones hab WHERE hab.disponibilidad = :disponibilidad", Hotel.class);
		myQuery.setParameter("disponibilidad", disponibilidad);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}
	
}
