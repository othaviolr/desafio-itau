package com.othavio.desafio_itau.service.validacoes.impl;

import com.othavio.desafio_itau.dto.TransacaoRequest;
import com.othavio.desafio_itau.exception.DataHoraException;
import com.othavio.desafio_itau.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ValidaCampoDataImpl  implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        boolean ehDepois = request.dataHora().isAfter(OffsetDateTime.now());
        if (ehDepois) {
            throw new DataHoraException("Data e Hora esta no futuro");
        }
    }
}
