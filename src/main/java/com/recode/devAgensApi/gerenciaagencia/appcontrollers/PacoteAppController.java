package com.recode.devAgensApi.gerenciaagencia.appcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recode.devAgensApi.model.Pacote;
import com.recode.devAgensApi.repository.PacoteRepository;

@Controller
@RequestMapping("pacote")
public class PacoteAppController {
	
	@Autowired
	private PacoteRepository repository;
	
	@GetMapping("gerencia")
	public String gerencia(Model model) {
		List<Pacote> pacotes = repository.findAll();
		model.addAttribute("pacotes", pacotes);
		
		return "pacote/gerencia";
	}

}
