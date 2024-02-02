package com.uce.edu.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.empresa.ICiudadanoRepository;
import com.uce.edu.empresa.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public List<Ciudadano> buscarCiudadanoInnerJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoInnerJoin();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoRightJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoRightJoin();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoLeftJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoLeftJoin();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoFullJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoFullJoin();
	}

	@Override
	public List<Ciudadano> buscarCiudadanoFetchJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanoFetchJoin();
	}

}
