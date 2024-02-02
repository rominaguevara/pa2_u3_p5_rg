package com.uce.edu.empresa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.empresa.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ciudadano> seleccionarCiudadanoInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c INNER JOIN c.empleado d", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();//señal
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c RIGHT JOIN c.empleado d", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();//señal
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c LEFT JOIN c.empleado d", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();//señal
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c FULL JOIN c.empleado d", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();//señal
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanoFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c, Empleado d WHERE c = d.ciudadano", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre();// señal
		}
		return lista;
	}

}
