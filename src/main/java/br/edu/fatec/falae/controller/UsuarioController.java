package br.edu.fatec.falae.controller;

import java.util.Optional;

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
	
	
	@PostMapping("/auth")
	public ResponseEntity<Usuario> auth(@RequestBody Usuario user) {
		String email = user.getEmail();
		String password = user.getPassword();
		
		Optional<Usuario> usuario = userService.authenticate(email, password);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> recuperate(@PathVariable("id") Integer id){
		Usuario created = userService.findById(id).get();
		return ResponseEntity.ok(created);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario user){
		Usuario created = userService.save(user);
		return ResponseEntity.ok(created);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable("id") Integer id){
		
		if(userService.findById(id).isPresent()) {
			userService.delete(id);
		}
		
		return ResponseEntity.ok(null);
	}
	
}
	
	