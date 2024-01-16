package com.uce.edu.repository;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public CuentaBancaria seleccionar(Integer id);
	
	public void insertar(CuentaBancaria cuentabancaria);
	
	public void actualizar(CuentaBancaria cuentabancaria);
	
	public void eliminar(Integer id);
	
	public CuentaBancaria seleccionarPorCuenta(String numero);

	public CuentaBancaria seleccionarPorSaldo(BigDecimal saldo);
}
