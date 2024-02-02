package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.biblioteca.repository.modelo.Autor;
import com.uce.edu.biblioteca.service.IAutorService;
import com.uce.edu.empresa.modelo.Ciudadano;
import com.uce.edu.empresa.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U3P5RgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IAutorService autorService;

 
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("INNER");
		List<Ciudadano> list1 = this.ciudadanoService.buscarCiudadanoInnerJoin();
		for(Ciudadano c1 : list1) {
			System.out.println(c1);		
		}
		List<Autor> list6 = this.autorService.buscarAutorInnerJoin();
		for(Autor a1 : list6) {
			System.out.println(a1);		
		}
		
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("RIGHT");
		List<Ciudadano> list2 =this.ciudadanoService.buscarCiudadanoRightJoin();
		for(Ciudadano c2 : list2) {
			System.out.println(c2);		
		}
		List<Autor> list7 = this.autorService.buscarAutorInnerJoin();
		for(Autor a2 : list7) {
			System.out.println(a2);		
		}
		
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("LEFT");
		List<Ciudadano> list3 =this.ciudadanoService.buscarCiudadanoLeftJoin();
		for(Ciudadano c3 : list3) {
			System.out.println(c3);		
		}
		List<Autor> list8 = this.autorService.buscarAutorInnerJoin();
		for(Autor a3 : list8) {
			System.out.println(a3);		
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("FULL");
		List<Ciudadano> list4 =this.ciudadanoService.buscarCiudadanoFullJoin();
		for(Ciudadano c4 : list4) {
			System.out.println(c4);		
		}
		List<Autor> list9 = this.autorService.buscarAutorInnerJoin();
		for(Autor a4 : list9) {
			System.out.println(a4);		
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("FECTH");
		List<Ciudadano> list5 =this.ciudadanoService.buscarCiudadanoFetchJoin();
		for(Ciudadano c5 : list5) {
			System.out.println(c5);		
		}
		List<Autor> list10 = this.autorService.buscarAutorInnerJoin();
		for(Autor a5 : list10) {
			System.out.println(a5);		
		}
	}

}
