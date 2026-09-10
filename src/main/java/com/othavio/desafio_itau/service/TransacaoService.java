package com.othavio.desafio_itau.service;

import com.othavio.desafio_itau.domain.Transacao;
import com.othavio.desafio_itau.dto.TransacaoRequest;
import com.othavio.desafio_itau.service.validacoes.Validacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    private final List<Validacao> validacaos;

    public TransacaoService(List<Validacao> validacaos) {
        this.validacaos = validacaos;
    }

    public void salvar(TransacaoRequest request) {
        validacaos.forEach(v -> v.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }

    public void deletar(){
        transacoes.clear();
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
