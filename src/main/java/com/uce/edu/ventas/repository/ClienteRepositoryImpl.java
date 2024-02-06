package com.uce.edu.ventas.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	//@Transactional(value= TxType.MANDATORY)//TODOS LOS METODOS DE LA CAPA REPOSITORY DEBEN TENER MANDATORY, EXCEPTO LOS MÉTODOS QUE NO AFECTA A LA BASE DE DATOS ES DECIR EL SELECT, PARA LOS SELECT DEBEN SER LOS NOT_SUPPORTED
	//begin
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Antes de la ejecución");
		try {
		this.entityManager.persist(cliente);
		}catch (RuntimeException e) {
			System.out.println(e.getClass());
		}
		System.out.println("Despues de ejecución");
	}//commit

}
