package com.recode.devAgensApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recode.devAgensApi.model.Pacote;
import com.recode.devAgensApi.service.PacoteService;


@RestController
@RequestMapping("pacotes")
public class PacoteController {

	@Autowired
	private PacoteService service;
	
	@GetMapping
	public ResponseEntity<List<Pacote>> getAll() {
	    List<Pacote> pacotes = service.getAll();
	    return ResponseEntity.ok().body(pacotes);
	}
}
