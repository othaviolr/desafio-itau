package com.othavio.desafio_itau.service.validacoes.impl;

import com.othavio.desafio_itau.dto.TransacaoRequest;
import com.othavio.desafio_itau.exception.ValorNegativoException;
import com.othavio.desafio_itau.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaValorNegativoImpl  implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        boolean ehNumeroNegativo = request.valor() < 0;

        if (ehNumeroNegativo) {
            throw new ValorNegativoException("Valor nao pode ser negativo");
        }
    }
}
