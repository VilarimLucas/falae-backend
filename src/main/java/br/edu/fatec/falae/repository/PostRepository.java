package br.edu.fatec.falae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.falae.model.Post;
import br.edu.fatec.falae.model.Usuario;

@Repository
public interface PostRepository  extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(Usuario user);
}
