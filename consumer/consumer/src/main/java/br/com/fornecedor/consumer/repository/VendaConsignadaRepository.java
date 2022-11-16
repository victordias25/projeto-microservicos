package br.com.fornecedor.consumer.repository;

import br.com.fornecedor.consumer.model.VendaConsignada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaConsignadaRepository extends JpaRepository<VendaConsignada, Long> {
    List<VendaConsignada> findByChassiVeiculo(String chassiVeiculo);
}
