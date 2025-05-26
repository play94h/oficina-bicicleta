package br.com.SystemBike.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.SystemBike.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
