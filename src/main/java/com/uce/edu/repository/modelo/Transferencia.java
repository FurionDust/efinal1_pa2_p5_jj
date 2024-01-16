package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@Column(name = "trans_id")
	private Integer id;
	@Column(name = "trans_fecha_transferencia")
	private LocalDateTime fechaTransferencia;
	@Column(name = "trans_cuenta_origen")
	private String cuentaOrigen;
	@Column(name = "trans_cuenta_destino")
	private String cuentaDestino;
	@Column(name = "trans_monto")
	private BigDecimal monto;
	@Column(name = "trans_comision")
	private BigDecimal comision;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFechaTransferencia() {
		return fechaTransferencia;
	}
	public void setFechaTransferencia(LocalDateTime fechaTransferencia) {
		this.fechaTransferencia = fechaTransferencia;
	}
	
	public String getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public String getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getComision() {
		return comision;
	}
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}
	
	
	

}
