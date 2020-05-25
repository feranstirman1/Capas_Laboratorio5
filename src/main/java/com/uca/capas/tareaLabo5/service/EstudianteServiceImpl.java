package com.uca.capas.tareaLabo5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.tareaLabo5.dao.EstudianteDAO;
import com.uca.capas.tareaLabo5.domain.Estudiante;

@Repository
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		estudianteDAO.insert(estudiante);
		
	}

	@Override
	@Transactional
	public void borrar(Integer codigo) throws DataAccessException {
		estudianteDAO.borrar(codigo);
		
	}

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		return estudianteDAO.findOne(codigo);
	}

}
