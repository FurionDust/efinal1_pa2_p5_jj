package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insetar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

	@Override
	public Transferencia seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	public List<Transferencia> seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t WHERE t.id =:id",Transferencia.class);
		myQuery.setParameter("id", id);
		return myQuery.getResultList();
	}

}
