package br.com.SystemBike.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.SystemBike.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
	Usuario findByUsernameAndPassword(String username, String password);
}
