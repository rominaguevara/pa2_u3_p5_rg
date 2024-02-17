package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		///////////////////////////////////////////////////////////////////
		// 1.Supplier
		System.out.println("SUPPLIER");
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		// Lambdas
		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "465465465";
			cedula = cedula + "canton";
			return cedula;
		};// con el () vacío re´resentamos que no recibe ningúna argumento
		System.out.println(supplierLambda.getId());

		IPersonaSupplier<String> supplierLambda2 = () -> "465465465" + "canton2";// esto funciona cuando tengo una única
																					// línea incluso ya no es necesario
																					// el return
		System.out.println(supplierLambda2.getId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());

		///////////////////////////////////////////////////////////////////
		// 2.CONSUMER
		System.out.println("\nCONSUMER");
		// Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		// Lambdas
		System.out.println("Lambdas");
		IPersonaConsumer<String> consumerLambda = cadena -> {// cadena es solo el nombre del parámetro, como es un solo
																// argumento puede ir sin () pero si es más de uno si es
																// necesario el ()
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");

		///////////////////////////////////////////////////////////////////
		//3.Predicate
		System.out.println("\nPREDICATE");
		//Clases
		//aqui como es lo mismo de todo el semestre ya no se hace para ejemplo
		
		//Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero ->numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> predicateLambda1 = letra -> "Edison".contains(letra);
		System.out.println(predicateLambda1.evaluar("a"));
		
		
	}

}
