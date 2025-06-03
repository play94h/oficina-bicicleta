package br.com.SystemBike.Cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.SystemBike.Entity.Usuario;
import br.com.SystemBike.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario>listarTodos(){
		return usuarioService.listarUser();
	} 

	@GetMapping("/{username}")
	public Usuario buscarPorUsername(@PathVariable String username) {
		return usuarioService.buscarPorUsername(username);
	}
	
	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
	}

	@PostMapping
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.salvarUsuario(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
	    Usuario usuario = usuarioService.login(loginRequest.getUsername(), loginRequest.getPassword());

	    if (usuario == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
	    }

	    return ResponseEntity.ok(usuario);
	}




}
