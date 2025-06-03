package br.com.SystemBike.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.SystemBike.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
