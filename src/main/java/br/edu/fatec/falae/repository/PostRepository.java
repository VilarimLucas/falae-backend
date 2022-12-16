package br.edu.fatec.falae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.falae.model.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post, Integer>{
	
}
