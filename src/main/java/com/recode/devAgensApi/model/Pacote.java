package com.recode.devAgensApi.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Pacote implements Serializable{

	private static final long serialVersionUID = -1695033425554134415L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "preco")
	private BigDecimal preco;
	@Column(name = "dias_estadia")
	private byte diasEstadia;
	@OneToOne
	private Destino destino;
	
	public Pacote() {
		
	}
	
	public Pacote(BigDecimal preco, byte diasEstadia) {
		this.preco = preco;
		this.diasEstadia = diasEstadia;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public byte getDiasEstadia() {
		return diasEstadia;
	}
	public void setDiasEstadia(byte diasEstadia) {
		this.diasEstadia = diasEstadia;
	}
	
	
	
}
