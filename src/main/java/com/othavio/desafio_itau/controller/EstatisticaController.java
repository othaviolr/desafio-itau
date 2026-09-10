package com.othavio.desafio_itau.controller;

import com.othavio.desafio_itau.dto.EstatisticaResponse;
import com.othavio.desafio_itau.service.EstatisticaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/estatistica")
@RestController
public class EstatisticaController {

    private final EstatisticaService service;

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EstatisticaResponse obterMetricas() {
        return service.obterMetricas();
    }
}
