package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)//T2
	//begin
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
		this.clienteRepository.insertar(cliente);
		}catch(Exception e) {
			System.out.println(e.getClass());
		}
		//commit
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Este es un método supports");
		System.out.println("Prueba Supports: "+TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Este es un método never");
		System.out.println("Prueba Never: "+TransactionSynchronizationManager.isActualTransactionActive());
	}

}
