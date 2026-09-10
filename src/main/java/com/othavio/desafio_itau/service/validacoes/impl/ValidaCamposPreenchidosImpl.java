package com.othavio.desafio_itau.service.validacoes.impl;

import com.othavio.desafio_itau.dto.TransacaoRequest;
import com.othavio.desafio_itau.exception.FormularioInvalidoException;
import com.othavio.desafio_itau.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaCamposPreenchidosImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        if (request.valor() == null || request.dataHora() == null) {
            throw new FormularioInvalidoException("Campos nao podem ser nulos");
        }
    }
}
