package com.uce.edu.ventas.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IClienteService clienteService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)//T1
	//begin
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		BigDecimal valor = new BigDecimal(100);
		valor =valor.multiply(new BigDecimal(0.12)); 
		factura.setValorIVA(valor);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.iFacturaRepository.insertar(factura);
		System.out.println("Paso el insert de factura");
		this.clienteService.guardar(cliente);
		System.out.println("Paso el insert de cliente");
	}
	//commit
	//Aquí es lo que salta el error

	@Override
	@Transactional(value = TxType.MANDATORY)//si no esxiste una transacción abierta lanza una excepción
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Este método es de prueba");
		System.out.println("Prueba: "+TransactionSynchronizationManager.isActualTransactionActive());
		
	}
	@Override
	//@Transactional(value  = TxType.REQUIRED)//CON REQUIRED O REQUIRES_NEW SIEMPRE TENDRÁ UNA NUEVA TRANSACCIÓN
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();
	}
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaNever();
	}
}
