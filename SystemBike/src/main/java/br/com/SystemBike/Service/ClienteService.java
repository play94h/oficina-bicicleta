package br.com.SystemBike.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SystemBike.Entity.Cliente;
import br.com.SystemBike.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}

}
