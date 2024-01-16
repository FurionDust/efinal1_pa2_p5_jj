package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Propietario seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Propietario propietario = this.seleccionar(id);
		this.entityManager.remove(propietario);
	}

}
