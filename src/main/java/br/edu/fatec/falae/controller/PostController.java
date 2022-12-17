package br.edu.fatec.falae.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.edu.fatec.falae.service.UsuarioService;

@RestController
@RequestMapping("/posts")

public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UsuarioService userService;
	
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Map<String, String> post){
		Post created=new Post();
		created.setUser(userService.findById(Integer.parseInt(post.get("user_id"))).get());
		created.setComment(post.get("comment"));
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(created));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> get(@PathVariable("id") Integer id){
		Post created =postService.findById(id).get();
		return ResponseEntity.ok(created);
	}
	
	@PutMapping
	public ResponseEntity<Post> recuperate(@RequestBody Map<String, String> post){
		Post created=new Post();
		created.setId(Integer.parseInt(post.get("id")));
		created.setUser(userService.findById(Integer.parseInt(post.get("user_id"))).get());
		created.setComment(post.get("comment"));
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(created));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> delete(@PathVariable("id") Integer id){
		
		if(postService.findById(id).isPresent()) {
			postService.delete(id);
		}
		return ResponseEntity.ok(null);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = postService.findAll();
		
		return ResponseEntity.ok(list);
	}
}
