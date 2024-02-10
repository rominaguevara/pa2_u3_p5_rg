package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {

	public void guardar(Factura factura, Cliente cliente);
	
	public void prueba();
	
	public void pruebaSupports();
	
	public void pruebaNever();
	
}
