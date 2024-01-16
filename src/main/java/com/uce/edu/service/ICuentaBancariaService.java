package com.uce.edu.service;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	public CuentaBancaria buscar(Integer id);

	public void guardar(CuentaBancaria cuentabancaria);

	public void actualizar(CuentaBancaria cuentabancaria);

	public void eliminar(Integer id);
	
	public CuentaBancaria seleccionarPorSaldo(BigDecimal saldo);

}
