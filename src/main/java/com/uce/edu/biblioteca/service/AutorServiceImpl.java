package com.uce.edu.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.biblioteca.repository.IAutorRepository;
import com.uce.edu.biblioteca.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository autorRepository;
	
	@Override
	public List<Autor> buscarAutorInnerJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorInnerJoin();
	}

	@Override
	public List<Autor> buscarAutorRightJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorRightJoin();
	}

	@Override
	public List<Autor> buscarAutorLeftJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorLeftJoin();
	}

	@Override
	public List<Autor> buscarAutorFullJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorFullJoin();
	}

	@Override
	public List<Autor> buscarAutorFetchJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutorFetchJoin();
	}

}
