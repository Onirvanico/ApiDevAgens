package com.recode.devAgensApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recode.devAgensApi.model.Reserva;
import com.recode.devAgensApi.service.ReservaService;


@RequestMapping("reservas")
@RestController
public class ReservaController {

	@Autowired
	private ReservaService service;
	
	@GetMapping
	public ResponseEntity<List<Reserva>> getAll() {
		return ResponseEntity.ok().body(service.getAll()); 
	}
	
	@PostMapping
	public ResponseEntity<Reserva> save(@RequestBody Reserva reserva) {
		Reserva savedReserva = service.save(reserva);
		return ResponseEntity.ok().body(savedReserva);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Reserva> findById(@PathVariable("id") Integer id) {
		Reserva reserva = service.findById(id);
		return ResponseEntity.ok().body(reserva);
	}
}
