package com.uce.edu.repository;import java.util.List;

import com.uce.edu.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;

public interface ITransferenciaRepository {

	public void insetar(Transferencia transferencia);
	
	public Transferencia seleccionar(Integer id);
	
	public List<Transferencia> seleccionarPorId(Integer id);
	
}
