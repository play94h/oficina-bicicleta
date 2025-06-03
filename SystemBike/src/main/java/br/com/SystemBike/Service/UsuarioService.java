package br.com.SystemBike.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SystemBike.Entity.Usuario;
import br.com.SystemBike.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public List<Usuario> listarUser(){
		return usuarioRepository.findAll();
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}


	public Usuario buscarPorUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	   public Usuario login(String username, String password) {
	        Usuario usuario = usuarioRepository.findByUsernameAndPassword(username,password);

	        if (usuario !=null && usuario.getPassword().equals(password)) {
	            return usuario;
	        }

	        return null; 
	}
}
