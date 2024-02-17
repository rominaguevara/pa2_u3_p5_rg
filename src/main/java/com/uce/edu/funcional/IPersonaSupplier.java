package com.uce.edu.funcional;

@FunctionalInterface

public interface IPersonaSupplier <T>{ //<T> es el genérico "T" solo es el nombre que le quiero dar
	public T getId();
	
}
