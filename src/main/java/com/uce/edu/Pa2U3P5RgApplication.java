package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5RgApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService; 
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//this.facturaService.pruebaSupports();
		
		//this.facturaService.pruebaNever();
	}

	//finalmente el que determina el comportamiento del supports es el padre
	//LA TRANSACCIÓN NEVER dice, si existe una transacción abierta se lanza una excepción
}
