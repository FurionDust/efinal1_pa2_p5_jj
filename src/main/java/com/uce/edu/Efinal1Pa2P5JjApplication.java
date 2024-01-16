package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.service.ICuentaBancariaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.ITransferenciaService;

@SpringBootApplication
public class Efinal1Pa2P5JjApplication implements CommandLineRunner{

	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired 
	private ITransferenciaService iTransferenciaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

		
		CuentaBancaria cta1 = new CuentaBancaria();
		cta1.setNumero("1234");
		cta1.setSaldo(new BigDecimal(1000));
		cta1.setTipo("Corriente");
		
		CuentaBancaria cta2 = new CuentaBancaria();
		cta2.setNumero("1235");
		cta2.setSaldo(new BigDecimal(0));
		cta2.setTipo("Ahorros");
		
		Propietario prop1 = new Propietario();
		prop1.setCedula("1719608729");
		prop1.setNombre("Alejandro");
		prop1.setApellido("Jiménez");
		prop1.setCuentabancaria(cta1);
		
		Propietario prop2 = new Propietario();
		prop2.setCedula("1719608728");
		prop2.setNombre("José");
		prop2.setApellido("Loor");
		prop2.setCuentabancaria(cta2);
		
		cta1.setPropietario(prop1);
		cta2.setPropietario(prop2);
		
		
		this.bancariaService.guardar(cta1);
		this.bancariaService.guardar(cta2);
		
		this.iTransferenciaService.realizarTransferencia("1234", "1235", new BigDecimal(100));
		
		CuentaBancaria cta1ver = this.bancariaService.buscar(1);
		System.out.println(cta1ver);
		
		CuentaBancaria cta2ver = this.bancariaService.buscar(2);
		System.out.println(cta2ver);
		
		
	}

}
