package br.com.concessionaria.producer.controller.dto;

import br.com.concessionaria.producer.model.Cliente;

public class ClienteResponse {
    public static ClienteResponse converter(Cliente c) {
        var cliente = new ClienteResponse();
        cliente.setId_cliente(c.getIdCliente());
        cliente.setCpf(c.getCpf());
        cliente.setNome(c.getNome());
        cliente.setSobrenome(c.getSobrenome());
        cliente.setDataNascimento(c.getDataNascimento());
        cliente.setSexo(c.getSexo());
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
    private String cpf;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String sexo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
