package br.com.SystemBike.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "nome", length = 140, nullable = false)
	private String nome;

	@Column(name = "cpf", length = 26, nullable = false, unique = true)
	private String cpf;

	@Column(name = "telefone", length = 35, nullable = false)
	private String telefone;

	@Column(name = "email", length = 150, nullable = false)
	private String email; 

	public Cliente() {

	}

	public Cliente(Long id_cliente, String nome, String cpf, String telefone, String email) {
		this.ID= id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId_cliente() {
		return ID;
	}

	public void setId_cliente(Long id_cliente) {
		this.ID = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
