package com.uce.edu.empresa;

import java.util.List;

import com.uce.edu.empresa.modelo.Ciudadano;

public interface ICiudadanoRepository {

	public List<Ciudadano> seleccionarCiudadanoInnerJoin();

	public List<Ciudadano> seleccionarCiudadanoRightJoin();

	public List<Ciudadano> seleccionarCiudadanoLeftJoin();

	public List<Ciudadano> seleccionarCiudadanoFullJoin();

	public List<Ciudadano> seleccionarCiudadanoFetchJoin();
}
