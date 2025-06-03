package br.com.SystemBike.Cotroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.SystemBike.Entity.ItemOrdem;
import br.com.SystemBike.Entity.OrdemDeServico;
import br.com.SystemBike.Entity.StatusOrdem;
import br.com.SystemBike.Repository.ClienteRepository;
import br.com.SystemBike.Repository.ItemOrdemRepository;
import br.com.SystemBike.Repository.OrdemDeServicoRepository;
import br.com.SystemBike.Service.OrdemDeServicoService;

@RestController
@CrossOrigin
@RequestMapping("/ordens")
public class OrdemDeServicoController {

	@Autowired
	private OrdemDeServicoService ordemDeServicoService;

	@Autowired
	private ItemOrdemRepository itemOrdemRepository;
	
	@Autowired
	private OrdemDeServicoRepository deServicoRepository;

	@GetMapping
	public List<OrdemDeServico> listarTodas() {
		return ordemDeServicoService.listarTodas();
	}

	@GetMapping("/status")
	public ResponseEntity<StatusOrdem[]> getAllStatuses() {
		return ResponseEntity.ok(StatusOrdem.values());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/criar")
	public OrdemDeServico criarOrdem(@RequestBody OrdemDeServico ordem) {
		return ordemDeServicoService.criarOrdem(ordem);
	}

	@GetMapping("/{id}/itens")
	public ResponseEntity<?> listarItensPorOrdem(@PathVariable Long id) {
		Optional<OrdemDeServico> ordemOptional = deServicoRepository.findById(id);
		if (ordemOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de serviço não encontrada.");
		}

		List<ItemOrdem> itens = itemOrdemRepository.findByOrdemDeServicoId(id);
		return ResponseEntity.ok(itens);
	}

}
