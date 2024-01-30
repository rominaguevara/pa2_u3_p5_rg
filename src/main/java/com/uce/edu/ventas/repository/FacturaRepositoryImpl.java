package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFactura().size();// Le digo que carge el detalle bajo demanda
		return fact;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM Factura f inner join detalle_factura d on
		// f.fact_id=d.defa_id_factura

		// select f1_0.fact_id,f1_0.fact_cedula,
		// f1_0.fact_fecha,f1_0.fact_numero
		// from factura f1_0 join detalle_factura df1_0
		// on f1_0.fact_id=df1_0.defa_id_factura

		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
//		for (Factura f : lista) {
//			f.getDetalleFactura().size();//señal
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f  RIGHT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f  LEFT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}
	
	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f  FULL JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		
		//SQL: SELECT f.* FROM factura f, detalle_factura d 
		//     WHERE  f.fact_id = d.defa_id_factura
		
		//JPQL: SELECT f FROM Factura f, DetalleFactura d 
		//      WHERE f = d.factura
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();//señal
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//SELECT f FROM Factura fJOIN FETCH f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFactura d", Factura.class);
		return myQuery.getResultList();
	}

}
