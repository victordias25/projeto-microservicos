package br.com.fornecedor.consumer.controller.dto;

import br.com.fornecedor.consumer.model.VendaConsignada;

public class VendaConsignadaResponse {
    public static VendaConsignadaResponse converter(VendaConsignada v) {
        var vendaConsignada = new VendaConsignadaResponse();
        vendaConsignada.setIdVendaConsignada(v.getIdVendaConsignada());
        vendaConsignada.setChassiVeiculo(v.getChassiVeiculo());
        vendaConsignada.setCnpjCliente(v.getCnpjCliente());
        vendaConsignada.setDataVendaConsignada(v.getDataVendaConsignada());
        vendaConsignada.setValorVendaConsignada(v.getValorVendaConsignada());
        return vendaConsignada;
    }

    private Long idVendaConsignada;
    private String chassiVeiculo;
    private String cnpjCliente;
    private String dataVendaConsignada;
    private String valorVendaConsignada;

    public Long getIdVendaConsignada() {
        return idVendaConsignada;
    }

    public void setIdVendaConsignada(Long idVendaConsignada) {
        this.idVendaConsignada = idVendaConsignada;
    }

    public String getChassiVeiculo() {
        return chassiVeiculo;
    }

    public void setChassiVeiculo(String chassiVeiculo) {
        this.chassiVeiculo = chassiVeiculo;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }

    public String getDataVendaConsignada() {
        return dataVendaConsignada;
    }

    public void setDataVendaConsignada(String dataVendaConsignada) {
        this.dataVendaConsignada = dataVendaConsignada;
    }

    public String getValorVendaConsignada() {
        return valorVendaConsignada;
    }

    public void setValorVendaConsignada(String valorVendaConsignada) {
        this.valorVendaConsignada = valorVendaConsignada;
    }
}
