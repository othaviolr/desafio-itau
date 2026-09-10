package com.othavio.desafio_itau.service.validacoes;

import com.othavio.desafio_itau.dto.TransacaoRequest;

public interface Validacao {

    void validar(TransacaoRequest request);
}
