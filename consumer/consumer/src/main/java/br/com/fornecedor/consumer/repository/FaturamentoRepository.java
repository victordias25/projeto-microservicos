package br.com.fornecedor.consumer.repository;

import br.com.fornecedor.consumer.model.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, Long> {

}
