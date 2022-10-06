package com.recode.devAgensApi.gerenciaagencia.appcontrollers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recode.devAgensApi.model.Destino;
import com.recode.devAgensApi.repository.DestinoRepository;

@Controller
@RequestMapping("destino")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class DestinoAppController {
	
	@Autowired
	DestinoRepository repository;    
	
	@GetMapping("/gerencia") 
	public String gerencia(Model model) {
		List<Destino> destinos = repository.findAll();
		              
		model.addAttribute("destinos", destinos); 
		return "/destino/gerencia";
	}  
	      
	@GetMapping("/form")
	public String  destinosForm(Destino destino) {
		             
		return "/destino/addDestinoForm";
	}       
	                             
	@PostMapping("/add") 
	public String addDestino(RedirectAttributes attributes, @Validated Destino destino, BindingResult result, @RequestParam("imagemDestino") MultipartFile file) {
		if(result.hasFieldErrors()) return "/destino/form";
		    
		try {                          
			destino.setImagem(file.getBytes());
			     
		} catch (IOException e) {
			e.printStackTrace(); 
		}    
		     
		repository.save(destino);
		attributes.addFlashAttribute("message", "Destino salvo com sucesso");
		return "redirect:/destino/gerencia";
	}                 
	                
	@GetMapping("/form/{id}")  
	public String updateForm(Model model, @PathVariable("id") Integer id ) {
		Destino destinoToChange = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id " + id));
		model.addAttribute("destino", destinoToChange);
		return "/destino/updateForm";    
	}      
	  
	@PostMapping("/form/update/{id}")
	public String changeDestino(RedirectAttributes attributes, @Validated Destino destino, BindingResult result, @RequestParam("imagemDestino") MultipartFile file) {
		if(result.hasErrors()) return "redirect:/destino/form";
		  
		try { 
			if(file.getOriginalFilename().isEmpty()) {
			    Optional<Destino> optional = repository.findById(destino.getId());
			    destino.setImagem(optional.get().getImagem());
			}
			else {
				destino.setImagem(file.getBytes());
				System.out.println("Veio preenchido" + file.getOriginalFilename());
			}                              
			     
		} catch (IOException e) {
			e.printStackTrace();
		}            
		
		attributes.addFlashAttribute("message", "Destino atualizado com sucesso");
		    
		repository.save(destino);
		return "redirect:/destino/gerencia";
	}
	  
	@GetMapping("/delete/{id}") 
	public String deleteDestino(RedirectAttributes attributes, @PathVariable("id") Integer id, Model model) {
		Destino destino = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id " + id));
		repository.delete(destino);
		attributes.addFlashAttribute("message", "Destino removido com sucesso!");
		return "redirect:/destino/gerencia";
	}
	
	@GetMapping("/image/{id}")
	@ResponseBody
	public byte[] showImage(@PathVariable("id") Integer id) {
		Optional<Destino> opt = repository.findById(id);
		Destino destino = opt.orElseThrow(() -> new IllegalArgumentException("Invalid user id " + id ));
		return destino.getImagem();
	}

}
