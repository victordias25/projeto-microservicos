package br.com.concessionaria.producer.controller;

import br.com.concessionaria.producer.controller.dto.VendaResponse;
import br.com.concessionaria.producer.controller.dto.VendaRq;
import br.com.concessionaria.producer.model.Venda;
import br.com.concessionaria.producer.repository.VendaRepository;
import br.com.concessionaria.producer.service.RequisicaoMensagemResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venda")
public class VendaController {
    private final VendaRepository vendaRepository;

    public VendaController(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @GetMapping("/")
    public List<VendaResponse> findAll() {
        var venda = vendaRepository.findAll();
        return venda
                .stream()
                .map(VendaResponse::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VendaResponse findById(@PathVariable("id") Long id) {
        var venda = vendaRepository.getOne(id);
        return VendaResponse.converter(venda);
    }

    @PostMapping("/")
    public void efetuarVenda(@RequestBody VendaRq venda) throws IOException, InterruptedException {
        var v = new Venda();
        v.setCpfCliente(venda.getCpfCliente());
        v.setChassiVeiculo(venda.getChassiVeiculo());
        v.setDataVenda(venda.getDataVenda());
        v.setValorVenda(venda.getValorVenda());
        vendaRepository.save(v);
        RequisicaoMensagemResource requisicaoMensagemResource = new RequisicaoMensagemResource();
        requisicaoMensagemResource.requisicaoMensagemResource(venda.getChassiVeiculo());
    }

    @PutMapping("/{id}")
    public void alterarVenda(@PathVariable("id") Long id, @RequestBody VendaRq venda) throws Exception {
        var v = vendaRepository.findById(id);

        if (v.isPresent()) {
            var vendaSalvar = v.get();
            vendaSalvar.setCpfCliente(venda.getCpfCliente());
            vendaSalvar.setChassiVeiculo(venda.getChassiVeiculo());
            vendaSalvar.setDataVenda(venda.getDataVenda());
            vendaSalvar.setValorVenda(venda.getValorVenda());

            vendaRepository.save(vendaSalvar);
        } else {
            throw new Exception("Cliente não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirVenda(@PathVariable Long id) {
        var venda = vendaRepository.findById(id);
        if (venda.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        vendaRepository.delete(venda.get());
    }
}
