package br.com.SystemBike.Cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.SystemBike.Entity.Produto;
import br.com.SystemBike.Service.ProdutoService;

@RestController
@CrossOrigin
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto>listarTodos() {
		return produtoService.listarTodos();
	}

	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return produtoService.buscarPorId(id);
	}

	@PostMapping("/salvarproduto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@PutMapping("/{id}/estoque")
	public void atualizarEstoque(@PathVariable Long id, @RequestParam int quantidade) {
		produtoService.atualizarEstoque(id, quantidade);
	}

}
