package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

///////////////////////////////////////////////////////////////////
		// 1.Supplier
		System.out.println("****************SUPPLIER");
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

		// Métodos referenciados
		System.out.println("Métodos referenciados");
		MetodosRefernciados met = new MetodosRefernciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;// "obtenerId" es el nombre del método que cumple el
																	// contrato
		System.out.println(supplierLambda4.getId());

///////////////////////////////////////////////////////////////////
		// 2.CONSUMER
		System.out.println("\n****************CONSUMER");
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

		// Métodos referenciados
		System.out.println("Métodos referenciados");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Profesor Referenciado");
///////////////////////////////////////////////////////////////////
		// 3.Predicate
		System.out.println("\n****************PREDICATE");
		// Clases
		// aqui como es lo mismo de todo el semestre ya no se hace para ejemplo

		// Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda1 = letra -> "Edison".contains(letra);
		System.out.println(predicateLambda1.evaluar("a"));

		// Métodos referenciados
		System.out.println("Métodos referenciados");
		IPersonaPredicate<String> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar("W"));
		
		IPersonaPredicate<Integer> predicate3 = met::evaluar;
		System.out.println(predicate3.evaluar(10));
///////////////////////////////////////////////////////////////////
		// 4.Function
		System.out.println("\n****************FUNCTION");
		// Clases
		// aqui como es lo mismo de todo el semestre ya no se hace para ejemplo

		// Lambdas
		System.out.println("Lambdas");
		IPersonaFunction<String, Integer> functionLambda = numero -> {// en el <> el primero es el parámetro que
																		// devuelve y el segundo es el que recibe
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};
		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Guevara");
		ciud.setNombre("Romina");
		ciud.setProvincia("Pichincha");

		Empleado empl = functionLambda1.aplicar(ciud);
		System.out.println(empl);

		// Métodos referenciados
		System.out.println("Métodos referenciados");
		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Mishell Guanuchi");
		empl2.setPais("Ecuador");
		IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
		Ciudadano ciud2 = function2.aplicar(empl2);
		System.out.println(ciud2);
		
///////////////////////////////////////////////////////////////////
		// 5.UNARY OPERATOR
		System.out.println("\n****************UNARY OPERATOR");
		// Clases
		// aqui como es lo mismo de todo el semestre ya no se hace para ejemplo

		// Lambdas
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> {
			return numero + (numero * 2);
		};
		System.out.println(unaryOperatorLambda.aplicar(14));

		// Métodos referenciados
		System.out.println("Métodos referenciados");
		IPersonaUnaryOperator<Empleado> unaryOperator = met::procesar;
		Empleado empl3 = unaryOperator.aplicar(empl2);
		System.out.println(empl3);
///////////////////////////////////////////////////////////////////
		// 5.1 UNARY OPERATOR FUNCTION
		System.out.println("\n****************UNARY OPERATOR FUNCTION");
		// Clases
		// aqui como es lo mismo de todo el semestre ya no se hace para ejemplo

		// Lambdas
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda2.aplicar(10));
	}

}
