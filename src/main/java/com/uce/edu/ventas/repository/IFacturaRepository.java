package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;


public interface IFacturaRepository {
		
	public void insertar(Factura factura);

	public List<Factura> seleccionarTodos();
}
