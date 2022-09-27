package com.recode.devAgensApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recode.devAgensApi.model.Destino;
import com.recode.devAgensApi.service.DestinoService;

@RequestMapping("destinos")
@RestController
public class DestinoController {
	
	@Autowired
	private DestinoService service;
	
	@GetMapping
	public ResponseEntity<List<Destino>> getAll() {
		List<Destino> destinos = service.getAll();
		return ResponseEntity.ok().body(destinos);
	}
	
	@PostMapping
	public ResponseEntity<Destino> save(@RequestBody Destino destino) {
		
		Destino savedDestino = service.save(destino);
		return ResponseEntity.ok().body(savedDestino);
	}
	
	@PutMapping("{id}")
    public ResponseEntity<Destino> update(@PathVariable("id") Integer id, @RequestBody Destino destino) {
		
		Destino savedDestino = service.update(id, destino);
		return ResponseEntity.ok().body(savedDestino);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
	    service.remove(id);
		return ResponseEntity.noContent().build();
	}

}
