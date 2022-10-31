package com.recode.devAgensApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recode.devAgensApi.model.Usuario;
import com.recode.devAgensApi.service.UsuarioService;

@RequestMapping("auth")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	
	@PostMapping
	public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
	    usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		Usuario newUsuario = service.save(usuario);
		return ResponseEntity.ok().body(newUsuario);
	}
	
	@GetMapping("login")
	public ResponseEntity<HttpStatus> signin(@RequestBody Usuario usuario) throws Exception{
		Authentication userAuth;
		
		AuthenticationManager authManager = new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());
			}
			
		};
		
		try { 
			userAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(userAuth);
		}catch(BadCredentialsException ex) {
			throw new Exception("Credential invalid");
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
