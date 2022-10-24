package com.recode.devAgensApi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 319348518443889739L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "num_viajantes")
	private int numViajantes;
	
	@Column(name = "data_hora")
	private Date dataHora;
	
	@Column(name = "total")
	private BigDecimal total;
	
	@ManyToOne
	private Pacote pacote;
	
	public Reserva() {
		
	}
	
	public Reserva(int numViajantes, Date dataHora, BigDecimal total, Pacote pacote) {
		this.numViajantes = numViajantes;
		this.dataHora = dataHora;
		this.total = total;
		this.pacote = pacote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumViajantes() {
		return numViajantes;
	}

	public void setNumViajantes(int numViajantes) {
		this.numViajantes = numViajantes;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	
	

}
