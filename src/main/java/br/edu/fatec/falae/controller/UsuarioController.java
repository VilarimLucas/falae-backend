package br.edu.fatec.falae.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.edu.fatec.falae.model.Usuario;
import br.edu.fatec.falae.service.UsuarioService;



@RestController
@RequestMapping("/users")

public class UsuarioController {
	@Autowired
	private UsuarioService userService;
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario user){
		Usuario created = userService.save(user);
		return ResponseEntity.ok(created);
	}
}
