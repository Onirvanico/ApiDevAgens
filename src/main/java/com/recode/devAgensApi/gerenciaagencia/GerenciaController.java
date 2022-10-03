/*
 * package com.recode.devAgensApi.gerenciaagencia;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.recode.devAgensApi.model.Destino; import
 * com.recode.devAgensApi.repository.DestinoRepository;
 * 
 * @Controller
 * 
 * @RequestMapping("destino") public class GerenciaController {
 * 
 * @Autowired DestinoRepository repository;
 * 
 * @GetMapping("/gerencia") public String gerencia(Model model) { List<Destino>
 * destinos = repository.findAll(); model.addAttribute("destinos", destinos);
 * return "destino/gerencia"; }
 * 
 * }
 */