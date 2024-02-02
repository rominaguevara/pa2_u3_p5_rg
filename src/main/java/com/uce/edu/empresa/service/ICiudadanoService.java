package com.uce.edu.empresa.service;

import java.util.List;

import com.uce.edu.empresa.modelo.Ciudadano;

public interface ICiudadanoService {
	
	public List<Ciudadano> buscarCiudadanoInnerJoin();

	public List<Ciudadano> buscarCiudadanoRightJoin();

	public List<Ciudadano> buscarCiudadanoLeftJoin();

	public List<Ciudadano> buscarCiudadanoFullJoin();

	public List<Ciudadano> buscarCiudadanoFetchJoin();
}
