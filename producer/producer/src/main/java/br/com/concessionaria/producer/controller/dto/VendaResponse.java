package br.com.concessionaria.producer.controller.dto;

import br.com.concessionaria.producer.model.Venda;

public class VendaResponse {
    public static VendaResponse converter(Venda v) {
        var venda = new VendaResponse();
        venda.setIdVenda(v.getIdVenda());
        venda.setCpfCliente(v.getCpfCliente());
        venda.setChassiVeiculo(v.getChassiVeiculo());
        venda.setDataVenda(v.getDataVenda());
        venda.setValorVenda(v.getValorVenda());
        return venda;
    }

    private Long idVenda;
    private String cpfCliente;
    private String chassiVeiculo;
    private String dataVenda;
    private String valorVenda;

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getChassiVeiculo() {
        return chassiVeiculo;
    }

    public void setChassiVeiculo(String chassiVeiculo) {
        this.chassiVeiculo = chassiVeiculo;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }
}
