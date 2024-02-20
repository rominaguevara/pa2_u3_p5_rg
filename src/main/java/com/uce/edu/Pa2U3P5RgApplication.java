package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.service.IClienteService;

@SpringBootApplication
public class Pa2U3P5RgApplication implements CommandLineRunner {

	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Nombre Hilo: "+Thread.currentThread().getName()); 
		 * long tiempoInicial = System.currentTimeMillis(); for(int i=0; i<100; i++) {
		 * Cliente cliente = new Cliente(); cliente.setNombre("CN"+i);
		 * cliente.setApellido("CA"+i); this.clienteService.guardar(cliente); } long
		 * tiempoFinal = System.currentTimeMillis();
		 * 
		 * long tiempoTranscurrido = (tiempoFinal -tiempoInicial)/1000;
		 * System.out.println("Tiempo transcurrido en seg: "+tiempoTranscurrido);
		 */
		// Tiempo transcurrido en seg:101

		
//		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for (int i = 1; i <= 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaCliente.add(cliente);
//		}
//		listaCliente.stream().forEach(cliente -> this.clienteService.guardar(cliente));
//
//		long tiempoFinal = System.currentTimeMillis();
//
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		System.out.println("Tiempo transcurrido en seg: "+tiempoTranscurrido);
		// Tiempo transcurrido en seg:101
		
		
		// Programación en paralelo o programación multiHilo
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente> listaCliente = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			listaCliente.add(cliente);
		}
		listaCliente.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en seg: "+tiempoTranscurrido);
		
	}
}
