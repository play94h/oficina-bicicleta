package br.com.SystemBike.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SystemBike.Entity.Cliente;
import br.com.SystemBike.Entity.ItemOrdem;
import br.com.SystemBike.Entity.Produto;
import br.com.SystemBike.Repository.ItemOrdemRepository;
import br.com.SystemBike.Repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemOrdensService {

	@Autowired
	private ItemOrdemRepository itemOrdemRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	public ItemOrdem salvarOrdem(ItemOrdem iordem) {

		return itemOrdemRepository.save(iordem);
	}

	public List<ItemOrdem> listarItemOrdens() {
		return itemOrdemRepository.findAll();
	}
	
	public ItemOrdem atualizarItem(Long id, ItemOrdem itemOrdemRecebido) {
        // Busca o item da ordem no banco de dados
        ItemOrdem itemOrdemExistente = itemOrdemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item de Ordem não encontrado!"));

        // Atualiza os campos do item da ordem
        itemOrdemExistente.setQuantidade(itemOrdemRecebido.getQuantidade());
        itemOrdemExistente.setPrecoUnitario(itemOrdemRecebido.getPrecoUnitario());
        itemOrdemExistente.setPrecoServico(itemOrdemRecebido.getPrecoServico());
        itemOrdemExistente.setLaudoServico(itemOrdemRecebido.getLaudoServico());

        // Atualiza o produto, se necessário
        if (itemOrdemRecebido.getProduto() != null && itemOrdemRecebido.getProduto().getId() != null) {
            Produto produto = produtoRepository.findById(itemOrdemRecebido.getProduto().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
            itemOrdemExistente.setProduto(produto);
        }

        // Salva e retorna o item atualizado
        return itemOrdemRepository.save(itemOrdemExistente);
    }
	
	public ItemOrdem buscarPorId(Long id) {
		return itemOrdemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item ordem não encontrado."));
	}
	

}
