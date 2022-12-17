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

import br.edu.fatec.falae.model.Answer;
import br.edu.fatec.falae.model.Post;
import br.edu.fatec.falae.service.AnswerService;
import br.edu.fatec.falae.service.PostService;
import br.edu.fatec.falae.service.UsuarioService;


@RestController
@RequestMapping("/answers")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Answer> create(@RequestBody Map<String, String> post){
		Answer created=new Answer();
		created.setUser(userService.findById(Integer.parseInt(post.get("user_id"))).get());
		created.setPost(postService.findById(Integer.parseInt(post.get("post_id"))).get());
		created.setComment(post.get("comment"));
		return ResponseEntity.status(HttpStatus.CREATED).body(answerService.save(created));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Answer> recuperate(@PathVariable("id") Integer id){
		Answer created = answerService.findById(id).get();
		if(answerService.findById(id).isPresent()) {
			created = answerService.findById(id).get();
		}
		return ResponseEntity.ok(created);
	}
	
	@PutMapping
	public ResponseEntity<Answer> update(@RequestBody  Map<String, String> answer){
		Answer created=new Answer();
		created.setId(Integer.parseInt(answer.get("id")));
		created.setUser(userService.findById(Integer.parseInt(answer.get("user_id"))).get());
		created.setPost(postService.findById(Integer.parseInt(answer.get("post_id"))).get());
		created.setComment(answer.get("comment"));
		return ResponseEntity.status(HttpStatus.CREATED).body(answerService.save(created));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Answer> delete(@PathVariable("id") Integer id){
		if(answerService.findById(id).isPresent()) {
			answerService.delete(id);
		}
		return ResponseEntity.ok(null);
	}
	
	@GetMapping
	public ResponseEntity<List<Answer>> findAll(){
		List<Answer> list = answerService.findAll();
		
		return ResponseEntity.ok(list);
	}
	
}
