package com.recode.devAgensApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.devAgensApi.model.Destino;
import com.recode.devAgensApi.repository.DestinoRepository;

@Service
public class DestinoService {

	@Autowired DestinoRepository repository;
	
	public List<Destino> getAll() {
		return repository.findAll();
	}
	
	public Destino save(Destino destino) {
		return repository.save(destino);
	}
	
	public Destino update(Integer id, Destino newDestino) {
		Destino destino = repository.findById(id).get();
		destino.setLocal(newDestino.getLocal());
		destino.setDescricao(newDestino.getDescricao());
		return repository.save(destino);
	}
	
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
