package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5RgApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;

 
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UPDATE");
		
		int cantidad = this.iFacturaService.actualizarFechas(LocalDateTime.of(2020, 1,15,12,50), LocalDateTime.of(2020, 1,15,12,0));
		System.out.println("Cantidad de registros actualizados");
		System.out.println(cantidad);
		
		System.out.println("DELETE");
		int eliminados = this.iFacturaService.borrarPorNumero("1593578");
		System.out.println("Cantidad de registros eliminados");
		System.out.println(eliminados);
		
		//this.iFacturaService.eliminar(1);
		
		//DTO: DATA TRANSFER Object(patron de diseño para transferir datos mediante un objeto)(me permite transferir datos desde la repository a la service)
		//se debe crear con los datos exlusivos que deso transferir
		
		
		System.out.println("DTO");
		List<FacturaDTO> listaDTO = this.iFacturaService.buscarFacturasDTO();
		for(FacturaDTO fDTO :listaDTO) {
			System.out.println(fDTO);
		}
	}

}
