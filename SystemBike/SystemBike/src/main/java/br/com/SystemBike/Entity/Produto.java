package br.com.SystemBike.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "preco", length = 15)
	private Double preco;

	@Column(name = "quantidadeestoque", length = 40)
	private Integer quantidadeEstoque;

	@Column(name = "desquicao", length = 150)
	private String desquicao;

	@Column(name = "marca", length = 50)
	private String marca;

	@Enumerated(EnumType.STRING)
	private GrupoProduto grupoproduto;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public GrupoProduto getGrupoproduto() {
		return grupoproduto;
	}

	public void setGrupoproduto(GrupoProduto grupoproduto) {
		this.grupoproduto = grupoproduto;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getDesquicao() {
		return desquicao;
	}

	public void setDesquicao(String desquicao) {
		this.desquicao = desquicao;
	}

}
