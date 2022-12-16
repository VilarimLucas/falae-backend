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

import br.edu.fatec.falae.model.Answer;
import br.edu.fatec.falae.service.AnswerService;


@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	@PostMapping
	public ResponseEntity<Answer> create(@RequestBody Answer user){
		Answer created = answerService.save(user);
		return ResponseEntity.ok(created);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Answer> get(@PathVariable("id") Integer id){
		Answer created = answerService.findById(id).get();
		
		if(answerService.findById(id).isPresent()) {
			created = answerService.findById(id).get();
		}
		
		return ResponseEntity.ok(created);
	}
	
	@PutMapping
	public ResponseEntity<Answer> recuperate(@RequestBody Answer answer){
		Answer created = answerService.save(answer);
		return ResponseEntity.ok(created);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Answer> delete(@PathVariable("id") Integer id){
		
		if(answerService.findById(id).isPresent()) {
			answerService.delete(id);
		}
		return ResponseEntity.ok(null);
	}
	
}
