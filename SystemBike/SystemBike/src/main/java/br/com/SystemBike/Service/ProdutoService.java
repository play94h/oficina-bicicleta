package br.com.SystemBike.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SystemBike.Entity.Produto;
import br.com.SystemBike.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));
	}

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void atualizarEstoque(Long id, int quantidade) {
		Produto produto = buscarPorId(id);
		produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
		produtoRepository.save(produto);
	}

}
