package br.com.fornecedor.consumer.controller;


import br.com.fornecedor.consumer.controller.dto.ClienteJuridicoResponse;
import br.com.fornecedor.consumer.controller.dto.ClienteJuridicoRq;
import br.com.fornecedor.consumer.model.ClienteJuridico;
import br.com.fornecedor.consumer.repository.ClienteJuridicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clienteJuridico")
public class ClienteJuridicoController {
    private final ClienteJuridicoRepository clienteRepository;

    public ClienteJuridicoController(ClienteJuridicoRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/")
    public List<ClienteJuridicoResponse> findAll() {
        var cliente = clienteRepository.findAll();
        return cliente
                .stream()
                .map(ClienteJuridicoResponse::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClienteJuridicoResponse findById(@PathVariable("id") Long id) {
        var cliente = clienteRepository.getOne(id);
        return ClienteJuridicoResponse.converter(cliente);
    }

    @PostMapping("/")
    public void cadastrarCliente(@RequestBody ClienteJuridicoRq cliente) {
        var c = new ClienteJuridico();
        c.setCnpj(cliente.getCnpj());
        c.setInscricaoEstadual(cliente.getInscricaoEstadual());
        c.setRazaoSocial(cliente.getRazaoSocial());
        c.setCep(cliente.getCep());
        c.setLogadouro(cliente.getLogadouro());
        c.setNumero(cliente.getNumero());
        c.setComplemento(cliente.getComplemento());
        c.setBairro(cliente.getBairro());
        c.setCidade(cliente.getCidade());
        c.setUf(cliente.getUf());
        c.setTelefone(cliente.getTelefone());
        c.setEmail(cliente.getEmail());
        clienteRepository.save(c);
    }

    @PutMapping("/{id}")
    public void alterarCliente(@PathVariable("id") Long id, @RequestBody ClienteJuridicoRq cliente) throws Exception {
        var c = clienteRepository.findById(id);

        if (c.isPresent()) {
            var clienteSalvar = c.get();
            clienteSalvar.setCnpj(cliente.getCnpj());
            clienteSalvar.setInscricaoEstadual(cliente.getInscricaoEstadual());
            clienteSalvar.setRazaoSocial(cliente.getRazaoSocial());
            clienteSalvar.setCep(cliente.getCep());
            clienteSalvar.setLogadouro(cliente.getLogadouro());
            clienteSalvar.setNumero(cliente.getNumero());
            clienteSalvar.setComplemento(cliente.getComplemento());
            clienteSalvar.setBairro(cliente.getBairro());
            clienteSalvar.setCidade(cliente.getCidade());
            clienteSalvar.setUf(cliente.getUf());
            clienteSalvar.setTelefone(cliente.getTelefone());
            clienteSalvar.setEmail(cliente.getEmail());
            clienteRepository.save(clienteSalvar);
        } else {
            throw new Exception("Cliente não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable Long id) {
        var cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        clienteRepository.delete(cliente.get());
    }
}
