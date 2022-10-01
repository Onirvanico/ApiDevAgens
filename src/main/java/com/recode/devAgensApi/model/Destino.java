package com.recode.devAgensApi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Destino implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String local;
	private String descricao;
	@Lob
	private byte[] imagem;
	
	public Destino() {
		
	}
	
	public Destino(String local, String descricao) {
		this.local = local;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricacao) {
		this.descricao = descricacao;
	}
	
	
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public byte[] getImagem() {
		return imagem;
	}
	

	@Override
	public String toString() {
		
		return "id: " + this.id +
				" local: " + this.local +
				" descricação: " + this.descricao;
	}
}
