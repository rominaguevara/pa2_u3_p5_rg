package com.uce.edu.biblioteca.repository;

import java.util.List;

import com.uce.edu.biblioteca.repository.modelo.Autor;

public interface IAutorRepository {

	public List<Autor> seleccionarAutorInnerJoin();

	public List<Autor> seleccionarAutorRightJoin();

	public List<Autor> seleccionarAutorLeftJoin();

	public List<Autor> seleccionarAutorFullJoin();

	public List<Autor> seleccionarAutorFetchJoin();

}
