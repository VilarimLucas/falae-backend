package br.edu.fatec.falae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.falae.model.Answer;
import br.edu.fatec.falae.model.Post;
import br.edu.fatec.falae.repository.AnswerRepository;

@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
	
	public Answer save(Answer answer) {
		return this.answerRepository.save(answer);
	}
	
	public void delete(Integer id) {
		this.answerRepository.deleteById(id);
	}
	
	public Optional<Answer> findById(Integer id) {
        return this.answerRepository.findById(id);
    }
	
	public List<Answer> findAll(){
		return this.answerRepository.findAll();	
		}
}
