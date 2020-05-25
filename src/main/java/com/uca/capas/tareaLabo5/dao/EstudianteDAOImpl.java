package com.uca.capas.tareaLabo5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.tareaLabo5.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		entityManager.persist(estudiante);
	}

	@Override
	@Transactional
	public void borrar(Integer codigo) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, codigo);
		entityManager.remove(estudiante);
		
	}

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		Estudiante estudiante = null;
		try {
			estudiante = entityManager.find(Estudiante.class, codigo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estudiante;
	}

}
