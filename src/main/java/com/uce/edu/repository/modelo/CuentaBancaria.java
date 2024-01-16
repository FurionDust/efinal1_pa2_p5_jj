package com.uce.edu.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "cuentabancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta")
	@SequenceGenerator(name = "seq_cuenta", sequenceName = "seq_cuenta", allocationSize = 1)
	@Column(name = "cuent_id")
	private Integer id;
	@Column(name = "cuent_numero")
	private String numero;
	@Column(name = "cuent_tipo")
	private String tipo;
	@Column(name = "cuent_saldo")
	private BigDecimal saldo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cuentabancaria_id_propietario")
	private Propietario propietario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo
				+ ", propietario=" + propietario + "]";
	}
	
	
	
}
