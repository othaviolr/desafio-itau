package com.othavio.desafio_itau.controller;


import com.othavio.desafio_itau.dto.TransacaoRequest;
import com.othavio.desafio_itau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transacao")
@RestController
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody TransacaoRequest request) {
        service.salvar(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletar() {
        service.deletar();
    }
}
