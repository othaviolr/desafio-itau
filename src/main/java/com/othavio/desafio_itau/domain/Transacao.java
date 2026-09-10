package com.othavio.desafio_itau.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Transacao {

    private Double valor;

    private OffsetDateTime dataHora;
}
