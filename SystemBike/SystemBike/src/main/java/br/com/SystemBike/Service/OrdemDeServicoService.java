package br.com.SystemBike.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SystemBike.Entity.Cliente;
import br.com.SystemBike.Entity.OrdemDeServico;
import br.com.SystemBike.Entity.StatusOrdem;
import br.com.SystemBike.Repository.ClienteRepository;
import br.com.SystemBike.Repository.OrdemDeServicoRepository;
import br.com.SystemBike.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class OrdemDeServicoService {

	@Autowired
	private OrdemDeServicoRepository ordemDeServicoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public List<OrdemDeServico> listarTodas() {
		return ordemDeServicoRepository.findAll();
	}
	
	@Transactional
	public OrdemDeServico criarOrdem(OrdemDeServico ordem) {

		return ordemDeServicoRepository.save(ordem);
	}
}
