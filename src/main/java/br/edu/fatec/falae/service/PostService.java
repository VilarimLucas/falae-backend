package br.edu.fatec.falae.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.falae.model.Post;
import br.edu.fatec.falae.model.Usuario;
import br.edu.fatec.falae.repository.PostRepository;

@Service
public class PostService {
	
	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
	
	public Post save(Post post) {
		return this.postRepository.save(post);
	}
	
	public void delete(Integer id) {
		this.postRepository.deleteById(id);
	}
	
	public Optional<Post> findById(Integer id) {
        return this.postRepository.findById(id);
    }

}
