package br.edu.fatec.falae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.falae.model.Answer;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
