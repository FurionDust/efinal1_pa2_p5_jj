package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	@Override
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepository.seleccionar(id);
	}

	@Override
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.insertar(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.actualizar(propietario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(id);
	}

}
