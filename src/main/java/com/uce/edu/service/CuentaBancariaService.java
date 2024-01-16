package com.uce.edu.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaService implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public CuentaBancaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(id);
	}

	@Override
	public void guardar(CuentaBancaria cuentabancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(cuentabancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentabancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentabancaria);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(id);
	}

	@Override
	public CuentaBancaria seleccionarPorSaldo(BigDecimal saldo) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorSaldo(saldo);
	}

}
