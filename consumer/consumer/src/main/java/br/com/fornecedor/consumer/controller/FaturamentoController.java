package br.com.fornecedor.consumer.controller;

import br.com.fornecedor.consumer.controller.dto.FaturamentoResponse;
import br.com.fornecedor.consumer.controller.dto.FaturamentoRq;
import br.com.fornecedor.consumer.model.Faturamento;
import br.com.fornecedor.consumer.repository.FaturamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faturamento")
public class FaturamentoController {
    private final FaturamentoRepository faturamentoRepository;

    public FaturamentoController(FaturamentoRepository faturamentoRepository) {
        this.faturamentoRepository = faturamentoRepository;
    }

    @GetMapping("/")
    public List<FaturamentoResponse> findAll() {
        var faturamento = faturamentoRepository.findAll();
        return faturamento
                .stream()
                .map(FaturamentoResponse::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FaturamentoResponse findById(@PathVariable("id") Long id) {
        var faturamento = faturamentoRepository.getOne(id);
        return FaturamentoResponse.converter(faturamento);
    }

    @PostMapping("/")
    public void cadastrarFaturamento(@RequestBody FaturamentoRq faturamento) {
        var f = new Faturamento();
        f.setChassiVeiculo(faturamento.getChassiVeiculo());
        f.setCnpjCliente(faturamento.getCnpjCliente());
        f.setDataFaturamento(faturamento.getDataFaturamento());
        f.setValorFaturamento(faturamento.getValorFaturamento());
        faturamentoRepository.save(f);
    }

    @PutMapping("/{id}")
    public void alterarFaturamento(@PathVariable("id") Long id, @RequestBody FaturamentoRq faturamento) throws Exception {
        var f = faturamentoRepository.findById(id);

        if (f.isPresent()) {
            var faturamentoSalvar = f.get();
            faturamentoSalvar.setChassiVeiculo(faturamento.getChassiVeiculo());
            faturamentoSalvar.setCnpjCliente(faturamento.getCnpjCliente());
            faturamentoSalvar.setDataFaturamento(faturamento.getDataFaturamento());
            faturamentoSalvar.setValorFaturamento(faturamento.getValorFaturamento());
            faturamentoRepository.save(faturamentoSalvar);
        } else {
            throw new Exception("Faturamento não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirFaturamento(@PathVariable Long id) {
        var faturamento = faturamentoRepository.findById(id);
        if (faturamento.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        faturamentoRepository.delete(faturamento.get());
    }
}
