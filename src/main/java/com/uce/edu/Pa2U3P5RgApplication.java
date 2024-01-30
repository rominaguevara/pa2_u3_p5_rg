package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5RgApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;

	// Join Types en Jakarta Persistence

	// 1) JOIN
	// 1.1) INNER JOIN
	// 1.2) OUTER JOIN
		// 1.2.1)RIGHT
		// 1.2.2)LEFT
		// 1.2.3)FULL

	// 2) JOIN WHERE

	// 3) FETCH JOIN
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("INNER JOIN");
		List<Factura> lista1 = this.iFacturaService.buscarFacturasInnerJoin();
		for(Factura f1: lista1) {
			System.out.println(f1.getNumero());
//			for(DetalleFactura d :f1.getDetalleFactura()) {
//				System.out.println(d.getNombreProducto());
//			}
		}
		
		
		System.out.println("WHERE JOIN");
		List<Factura> lista2 = this.iFacturaService.buscarFacturasWhereJoin();
		for(Factura f2: lista2) {
			System.out.println(f2.getNumero());
			for(DetalleFactura d :f2.getDetalleFactura()) {
				System.out.println(d.getNombreProducto());
			}
		}
		
		
		System.out.println("FETCH JOIN");
		List<Factura> lista3 = this.iFacturaService.buscarFacturasFetchJoin();
		for(Factura f3: lista3) {
			System.out.println(f3.getNumero());
			for(DetalleFactura d :f3.getDetalleFactura()) {
				System.out.println(d.getNombreProducto());
			}
		}
	}

}
