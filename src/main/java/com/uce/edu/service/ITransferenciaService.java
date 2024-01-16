package com.uce.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.repository.modelo.Transferencia;

public interface ITransferenciaService {

	public void insetar(Transferencia transferencia);

	public Transferencia seleccionar(Integer id);
	
	public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal monto);
	
	public List<Transferencia> verTodas(Integer id);
}
