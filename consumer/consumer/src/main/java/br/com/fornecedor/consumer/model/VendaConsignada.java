package br.com.fornecedor.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Entidade Venda Consignada
@Entity
@NoArgsConstructor
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Table(name = "vendaConsignada")
public class VendaConsignada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendaConsignada;
    private String chassiVeiculo;
    private String cnpjCliente;
    private String dataVendaConsignada;
    private String valorVendaConsignada;

}