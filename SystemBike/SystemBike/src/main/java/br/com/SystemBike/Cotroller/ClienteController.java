package br.com.SystemBike.Cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.SystemBike.Entity.Cliente;
import br.com.SystemBike.Service.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
	}

	@PostMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}

	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}

}
