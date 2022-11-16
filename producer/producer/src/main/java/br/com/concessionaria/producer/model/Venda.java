package br.com.concessionaria.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Entidade Venda de Veículo para Cliente Final
@Entity
@NoArgsConstructor
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idVenda;
    private String cpfCliente;
    private String chassiVeiculo;
    private String dataVenda;
    private String valorVenda;
}