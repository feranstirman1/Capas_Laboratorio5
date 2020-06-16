package com.uca.capas.tareaLabo5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.tareaLabo5.dao.EstudianteDAO;
import com.uca.capas.tareaLabo5.domain.Estudiante;
import com.uca.capas.tareaLabo5.repositories.EstudianteRepo;

@Repository
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);
		
	}

	@Override
	@Transactional
	public void borrar(Integer codigo) throws DataAccessException {
		estudianteRepo.deleteById(codigo);
		
	}

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		return estudianteRepo.getOne(codigo);
	}

}
