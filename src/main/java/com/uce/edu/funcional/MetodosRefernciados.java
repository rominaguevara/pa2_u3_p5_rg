package com.uce.edu.funcional;

public class MetodosRefernciados {

	// supplier
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "465465465";
		cedula = cedula + "referenciado";
		return cedula;
	}

	// consumer
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se procesó la cadena");
	}

	// predicate con string
	public boolean evaluar(String cadena) {
		return "Edison".contains(cadena);
	}

	// predicate con integer
	public boolean evaluar(Integer numero) {
		return 8 == numero;
	}

	//Function
	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		String nombre = empl.getNombreCompleto().split(" ")[0];
		String apellido = empl.getNombreCompleto().split(" ")[1];
		ciud.setApellido(apellido);
		ciud.setNombre(nombre);
		ciud.setProvincia("Pichincha");
		return ciud;
	}
	
	//UNARY OPERATOR
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto()+" ");
		empl.setPais(empl.getPais()+ " de nacimiento");
		return empl;
	}
}
