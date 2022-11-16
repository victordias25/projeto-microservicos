package br.com.fornecedor.consumer.controller.dto;

import br.com.fornecedor.consumer.model.Faturamento;

public class FaturamentoResponse {
    public static FaturamentoResponse converter(Faturamento f) {
        var faturamento = new FaturamentoResponse();
        faturamento.setIdFaturamento(f.getIdFaturamento());
        faturamento.setChassiVeiculo(f.getChassiVeiculo());
        faturamento.setCnpjCliente(f.getCnpjCliente());
        faturamento.setDataFaturamento(f.getDataFaturamento());
        faturamento.setValorFaturamento(f.getValorFaturamento());
        return faturamento;
    }

    private Long idFaturamento;
    private String chassiVeiculo;
    private String cnpjCliente;
    private String dataFaturamento;
    private String valorFaturamento;

    public Long getIdFaturamento() {
        return idFaturamento;
    }

    public void setIdFaturamento(Long idFaturamento) {
        this.idFaturamento = idFaturamento;
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

    public String getDataFaturamento() {
        return dataFaturamento;
    }

    public void setDataFaturamento(String dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    public String getValorFaturamento() {
        return valorFaturamento;
    }

    public void setValorFaturamento(String valorFaturamento) {
        this.valorFaturamento = valorFaturamento;
    }
}
