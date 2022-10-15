package com.recode.devAgensApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.devAgensApi.model.Pacote;
import com.recode.devAgensApi.repository.PacoteRepository;

@Service
public class PacoteService {

	@Autowired
	private PacoteRepository repository;
	
	public List<Pacote> getAll() {
		return repository.findAll();
	}
	
	public Pacote save(Pacote pacote) {
		return repository.save(pacote);
	}
	
	public Pacote update(Integer id, Pacote newPacote) {
		Pacote pacote = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("id inexistente"));
		pacote.setDiasEstadia(newPacote.getDiasEstadia());
		pacote.setPreco(newPacote.getPreco());
		return repository.save(pacote);
	}
	
	public void remove(Integer id) {
		repository.deleteById(id);
	}
	
	public Pacote findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}

	public List<Pacote> retrieveUntil(int limit) {
		return repository.retrieveUntil(limit);
	}
}
