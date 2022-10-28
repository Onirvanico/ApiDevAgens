package com.recode.devAgensApi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Destino implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String local;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@Lob
	private byte[] imagem;
	
	@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "destino")
	private List<Pacote> pacotes;
	
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
