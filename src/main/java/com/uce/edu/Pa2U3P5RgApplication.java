package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.hotel.repository.modelo.Hotel;
import com.uce.edu.hotel.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5RgApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;

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
		List<Hotel> listaHotel = this.iHotelService.buscarHotelInnerJoin("Carol Michel");
		for(Hotel h: listaHotel) {
			System.out.println(h);
		}
		
		
		System.out.println("LEFT JOIN");
		List<Hotel> listaHotel2 = this.iHotelService.buscarHotelLeftJoin("Pedernales");
		for(Hotel h: listaHotel2) {
			System.out.println(h);
		}
		
		System.out.println("RIGHT JOIN");
		List<Hotel> listaHotel3 = this.iHotelService.buscarHotelRightJoin("Matrimonial");
		for(Hotel h: listaHotel3) {
			System.out.println(h);
		}
		
		System.out.println("FULL JOIN");
		List<Hotel> listaHotel4 = this.iHotelService.buscarHotelFulltJoin("Disponible");
		for(Hotel h: listaHotel4) {
			System.out.println(h);
		}
	}

}
