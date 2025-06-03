package br.com.SystemBike.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;

	@Column(name = "username", length = 20, nullable = false, unique = true)
	private String username;

	@Column(name = "password", length = 25, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private cargoUsuario cargousuario;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public cargoUsuario getCargousuario() {
		return cargousuario;
	}

	public void setCargousuario(cargoUsuario cargousuario) {
		this.cargousuario = cargousuario;
	}

	
}
