package br.com.fornecedor.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Entidade Faturamento
@Entity
@NoArgsConstructor
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Table(name = "faturamento")
public class Faturamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFaturamento;
    private String chassiVeiculo;
    private String cnpjCliente;
    private String dataFaturamento;
    private String valorFaturamento;
}