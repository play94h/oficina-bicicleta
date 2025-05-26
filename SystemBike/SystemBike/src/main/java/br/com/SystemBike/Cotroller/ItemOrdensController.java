package br.com.SystemBike.Cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.SystemBike.Entity.Cliente;
import br.com.SystemBike.Entity.ItemOrdem;
import br.com.SystemBike.Service.ItemOrdensService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/itemordens")
public class ItemOrdensController {

	@Autowired
	private ItemOrdensService itemOrdensService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/salvar")
	public ItemOrdem SalvarOrdens(@RequestBody ItemOrdem Intordem) {

		return itemOrdensService.salvarOrdem(Intordem);
	}

	@GetMapping
	public List<ItemOrdem> listarT() {
		return itemOrdensService.listarItemOrdens();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemOrdem> editarItemOrdem(@PathVariable Long id, @RequestBody ItemOrdem itemOrdem) {
		try {

			ItemOrdem itemAtualizado = itemOrdensService.atualizarItem(id, itemOrdem);
			return ResponseEntity.ok(itemAtualizado);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/{id}")
	public ItemOrdem buscarPorId(@PathVariable Long id) {
		return itemOrdensService.buscarPorId(id);
	}

}
