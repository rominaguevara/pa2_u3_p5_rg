package com.uce.edu.biblioteca.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.biblioteca.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Autor> seleccionarAutorInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a INNER JOIN a.libros d", Autor.class);
		List<Autor> lista = myQuery.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();//señal
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarAutorRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a RIGHT JOIN a.libros d", Autor.class);
		List<Autor> lista = myQuery.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();//señal
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarAutorLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a LEFT JOIN a.libros d", Autor.class);
		List<Autor> lista = myQuery.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();//señal
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarAutorFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a FULL JOIN a.libros d", Autor.class);
		List<Autor> lista = myQuery.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();//señal
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarAutorFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros d", Autor.class);
		return myQuery.getResultList();
	}

}
