package br.com.SystemBike.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.SystemBike.Entity.ItemOrdem;

public interface ItemOrdemRepository extends JpaRepository<ItemOrdem, Long> {
	
	List<ItemOrdem> findByOrdemDeServicoId(Long ordemDeServicoId);

}
