package br.com.fornecedor.consumer.controller;

import br.com.fornecedor.consumer.controller.dto.VendaConsignadaResponse;
import br.com.fornecedor.consumer.controller.dto.VendaConsignadaRq;
import br.com.fornecedor.consumer.model.VendaConsignada;
import br.com.fornecedor.consumer.repository.VendaConsignadaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vendaConsignada")
public class VendaConsignadaController {
    private final VendaConsignadaRepository vendaConsignadaRepository;

    public VendaConsignadaController(VendaConsignadaRepository vendaConsignadaRepository) {
        this.vendaConsignadaRepository = vendaConsignadaRepository;
    }

    @GetMapping("/")
    public List<VendaConsignadaResponse> findAll() {
        var vendaConsignada = vendaConsignadaRepository.findAll();
        return vendaConsignada
                .stream()
                .map(VendaConsignadaResponse::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VendaConsignadaResponse findById(@PathVariable("id") Long id) {
        var vendaConsignada = vendaConsignadaRepository.getOne(id);
        return VendaConsignadaResponse.converter(vendaConsignada);
    }

    @PostMapping("/")
    public void cadastrarVendaConsignada(@RequestBody VendaConsignadaRq venda) {
        var v = new VendaConsignada();
        v.setChassiVeiculo(venda.getChassiVeiculo());
        v.setCnpjCliente(venda.getCnpjCliente());
        v.setDataVendaConsignada(venda.getDataVendaConsignada());
        v.setValorVendaConsignada(venda.getValorVendaConsignada());
        vendaConsignadaRepository.save(v);
    }

    @PutMapping("/{id}")
    public void alterarVendaConsignada(@PathVariable("id") Long id, @RequestBody VendaConsignadaRq venda) throws Exception {
        var v = vendaConsignadaRepository.findById(id);

        if (v.isPresent()) {
            var vendaConsignadaSalvar = v.get();
            vendaConsignadaSalvar.setChassiVeiculo(venda.getChassiVeiculo());
            vendaConsignadaSalvar.setCnpjCliente(venda.getCnpjCliente());
            vendaConsignadaSalvar.setDataVendaConsignada(venda.getDataVendaConsignada());
            vendaConsignadaSalvar.setValorVendaConsignada(venda.getValorVendaConsignada());
            vendaConsignadaRepository.save(vendaConsignadaSalvar);
        } else {
            throw new Exception("Venda Consignada não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirVendaConsignada(@PathVariable Long id) {
        var venda = vendaConsignadaRepository.findById(id);
        if (venda.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        vendaConsignadaRepository.delete(venda.get());
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<VendaConsignada>> finbyCartaoCredito(@RequestParam String chassiVeiculo) {
        return ResponseEntity.ok(vendaConsignadaRepository.findByChassiVeiculo(chassiVeiculo));
    }
}
