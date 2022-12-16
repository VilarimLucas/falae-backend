package br.edu.fatec.falae.controller;

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

import br.edu.fatec.falae.model.Post;
import br.edu.fatec.falae.service.PostService;


@RestController
@RequestMapping("/post")

public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Post user){
		Post created = postService.save(user);
		return ResponseEntity.ok(created);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> get(@PathVariable("id") Integer id){
		Post created = postService.findById(id).get();
		
		if(postService.findById(id).isPresent()) {
			created = postService.findById(id).get();
		}
		
		return ResponseEntity.ok(created);
	}
	
	@PutMapping
	public ResponseEntity<Post> recuperate(@RequestBody Post post){
		Post created = postService.save(post);
		return ResponseEntity.ok(created);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> delete(@PathVariable("id") Integer id){
		
		if(postService.findById(id).isPresent()) {
			postService.delete(id);
		}
		return ResponseEntity.ok(null);
	}
}
