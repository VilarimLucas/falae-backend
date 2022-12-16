package br.edu.fatec.falae.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.falae.model.Usuario;
import br.edu.fatec.falae.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository userRepository;
	
	public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public Usuario save(Usuario user) {
		return this.userRepository.save(user);
	}
	
	public void delete(Integer id) {
		this.userRepository.deleteById(id);
	}
	
	public Optional<Usuario> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
	
	public Optional<Usuario> findById(Integer id) {
        return this.userRepository.findById(id);
    }

	public Optional<Usuario> authenticate(String email, String password) {
		Optional<Usuario> user = this.userRepository.findByEmail(email);
		return (user.isPresent() && user.get().getPassword().equals(password)) ? user : Optional.empty();
	}
	
	
}
