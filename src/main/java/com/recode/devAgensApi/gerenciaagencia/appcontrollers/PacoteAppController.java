package com.recode.devAgensApi.gerenciaagencia.appcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.recode.devAgensApi.model.Destino;
import com.recode.devAgensApi.model.Pacote;
import com.recode.devAgensApi.repository.DestinoRepository;
import com.recode.devAgensApi.repository.PacoteRepository;
  
@Controller
@RequestMapping("pacote")
public class PacoteAppController {
	
	@Autowired
	private PacoteRepository repository;
	
	@Autowired
	private DestinoRepository destinorepo;
	
	@GetMapping("/gerencia")
	public ModelAndView gerencia() {
		List<Pacote> pacotes = repository.findAll();
		ModelAndView mav = new ModelAndView("/pacote/gerencia");
		
		mav.addObject("pacotes", pacotes);
		
		return mav;
	}    
	    
	@GetMapping("/form")    
	public ModelAndView pacoteForm(Pacote pacote) {
		           
		ModelAndView mav = new ModelAndView("/pacote/addPacoteForm");
		List<Destino> destinos = destinorepo.findAll();
		mav.addObject("destinos", destinos);   
		return mav; 
	}
	  
	@PostMapping("/add")           
	public ModelAndView addPacote(RedirectAttributes attributes, @Validated Pacote pacote, BindingResult result) {
		if(result.hasFieldErrors()) return new ModelAndView("/pacote/form");
		
		repository.save(pacote);
		attributes.addFlashAttribute("message", "Pacote salvo com êxito!");
		
		return new ModelAndView("redirect:/pacote/gerencia");
	}
	        
	@GetMapping("form/{id}")    
	public ModelAndView updatePacoteForm(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("/pacote/updatePacoteForm");
		Pacote pacote = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pacote id"));
		List<Destino> destinos = destinorepo.findAll();
		mav.addObject("destinos", destinos);                    
		mav.addObject("pacote", pacote);
		return mav;  
	}

	@PostMapping("/form/update/{id}")    
	public ModelAndView changePacote(RedirectAttributes attributes, @Validated Pacote pacote, BindingResult result) {
		if(result.hasErrors()) return new ModelAndView("redirect:/pacote/form");
		attributes.addFlashAttribute("message", "Pacote alterado com sucesso");
		ModelAndView mav = new ModelAndView("redirect:/pacote/gerencia");
		repository.save(pacote);      
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deletePacote(RedirectAttributes attributes, @PathVariable("id") Integer id) {
		 Pacote pacote = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pacote id"));
		 repository.delete(pacote);
		 attributes.addFlashAttribute("message", "Pacote removido com êxito");
		 return new ModelAndView("redirect:/pacote/gerencia");
	}
}
