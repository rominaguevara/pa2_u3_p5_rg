package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	
	public Factura seleccionarPorNumero(String numero);
	
	public void insertar(Factura factura);
	
	public List<Factura> seleccionarFacturasInnerJoin();
	
	public List<Factura> seleccionarFacturasRightJoin();
	
	public List<Factura> seleccionarFacturasLeftJoin();
	
	public List<Factura> seleccionarFacturasFullJoin();
	
	public List<Factura> seleccionarFacturasWhereJoin();
	
	public List<Factura> seleccionarFacturasFetchJoin();
	
	public void actualizar(Factura factura);

	public void eliminar(Integer id);
	
	public Factura buscar(Integer id);

	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);

	public int eliminarPorNumero(String numero);
	
	public List<FacturaDTO> seleccionarFacturasDTO (); 
}
