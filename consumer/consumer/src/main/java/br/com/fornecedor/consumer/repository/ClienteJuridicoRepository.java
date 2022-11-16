package br.com.fornecedor.consumer.repository;

import br.com.fornecedor.consumer.model.ClienteJuridico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJuridicoRepository extends JpaRepository<ClienteJuridico, Long> {

}
