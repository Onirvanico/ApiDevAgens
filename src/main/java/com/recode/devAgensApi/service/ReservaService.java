package com.recode.devAgensApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.devAgensApi.model.Reserva;
import com.recode.devAgensApi.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repository;
	
	
	public List<Reserva> getAll() {
		return repository.findAll();
	}
	
	public Reserva save(Reserva reserva) {
		return repository.save(reserva);
	}
	
	public Reserva findById(Integer id) {
		return repository
				.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}

}
