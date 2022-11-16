package br.com.fornecedor.consumer.controller.dto;

import br.com.fornecedor.consumer.model.ClienteJuridico;

public class ClienteJuridicoResponse {
    public static ClienteJuridicoResponse converter(ClienteJuridico c) {
        var cliente = new ClienteJuridicoResponse();
        cliente.setId_cliente(c.getIdCliente());
        cliente.setCnpj(c.getCnpj());
        cliente.setInscricaoEstadual(c.getInscricaoEstadual());
        cliente.setRazaoSocial(c.getRazaoSocial());
        cliente.setCep(c.getCep());
        cliente.setLogadouro(c.getLogadouro());
        cliente.setNumero(c.getNumero());
        cliente.setComplemento(c.getComplemento());
        cliente.setBairro(c.getBairro());
        cliente.setCidade(c.getCidade());
        cliente.setUf(c.getUf());
        cliente.setTelefone(c.getTelefone());
        cliente.setEmail(c.getEmail());
        return cliente;
    }

    private Long id_cliente;
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;
    private String cep;
    private String logadouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String email;

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
