package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional(value= TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Factura> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createNamedQuery("SELECT f FROM Factura f", Factura.class);
		return myQuery.getResultList();
	}

}
