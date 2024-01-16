package com.uce.edu.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CuentaBancaria seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void insertar(CuentaBancaria cuentabancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentabancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentabancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentabancaria);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaBancaria = this.seleccionar(id);
		this.entityManager.remove(cuentaBancaria);
	}

	@Override
	public CuentaBancaria seleccionarPorCuenta(String numeroCuenta) {
		// TODO Auto-generated method stub
		//JPQL: SELECT c FROM CuentaBancaria c WHERE c.numero =:numero
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =:numero",CuentaBancaria.class);
		myQuery.setParameter("numero", numeroCuenta);
		return myQuery.getSingleResult();
	}

	@Override
	public CuentaBancaria seleccionarPorSaldo(BigDecimal saldo) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.saldo =:saldo",CuentaBancaria.class);
		myQuery.setParameter("saldo", saldo);
		return myQuery.getSingleResult();
	}



}
