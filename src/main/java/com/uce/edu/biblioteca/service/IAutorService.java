package com.uce.edu.biblioteca.service;

import java.util.List;

import com.uce.edu.biblioteca.repository.modelo.Autor;

public interface IAutorService {

	public List<Autor> buscarAutorInnerJoin();

	public List<Autor> buscarAutorRightJoin();

	public List<Autor> buscarAutorLeftJoin();

	public List<Autor> buscarAutorFullJoin();

	public List<Autor> buscarAutorFetchJoin();
	
}
