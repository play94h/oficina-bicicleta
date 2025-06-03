package br.com.SystemBike.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemOrdem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private OrdemDeServico ordemDeServico;

	private Integer quantidade;
	
	@Column(length = 25)
	private Float precoUnitario;

	@Column(length = 255)
	private String laudoServico;

	@Column(length = 30)
	private Float precoServico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getLaudoServico() {
		return laudoServico;
	}

	public void setLaudoServico(String laudoServico) {
		this.laudoServico = laudoServico;
	}

	public Float getPrecoServico() {
		return precoServico;
	}

	public void setPrecoServico(Float precoServico) {
		this.precoServico = precoServico;
	}

}
