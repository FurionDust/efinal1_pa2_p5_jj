package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.ITransferenciaRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public void insetar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insetar(transferencia);
	}

	@Override
	public Transferencia seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(id);
	}

	@Override
	public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		//1. buscar la cuenta de origen
		CuentaBancaria cuentaOrigen =this.bancariaRepository.seleccionarPorCuenta(numeroOrigen);
		//2. se obtiene el saldo
		BigDecimal Saldo = cuentaOrigen.getSaldo();
		//3. validamos el saldo
		if(Saldo.compareTo(monto)>=0) {
			BigDecimal comision = Saldo.multiply(new BigDecimal(0.1));
			
			//4. Restamos del saldo actual el monto
			BigDecimal nuevoSaldo = Saldo.subtract(monto);
			//5. Restamos la comision
			BigDecimal saldoComision = nuevoSaldo.subtract(comision);
			//6. actualizamos la cuentaOrigen
			cuentaOrigen.setSaldo(saldoComision);
			this.bancariaRepository.actualizar(cuentaOrigen);
			//7. Buscamos la cuenta de destino
			CuentaBancaria cuentaDestino = this.bancariaRepository.seleccionarPorCuenta(numeroDestino);
			//8. obtenemos el saldo de la cuenta de destino
			BigDecimal saldoDestino = cuentaDestino.getSaldo();
			//9. le sumamos el monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			//10. Actualizamos la cuenta de destino
			cuentaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualizar(cuentaDestino);
			//11. Se crea la transferencia 
			
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(numeroOrigen);
			transferencia.setCuentaDestino(numeroDestino);
			transferencia.setFechaTransferencia(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setComision(comision);
			//12. se inserta la transferencia
			this.iTransferenciaRepository.insetar(transferencia);
			
			
		}else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public List<Transferencia> verTodas(Integer id) {
		// TODO Auto-generated method stub

		return null;
	}

}
