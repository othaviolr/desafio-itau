package com.othavio.desafio_itau.service;

import com.othavio.desafio_itau.domain.Transacao;
import com.othavio.desafio_itau.dto.EstatisticaResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private TransacaoService service;

    public EstatisticaService(TransacaoService service) {
        this.service = service;
    }

    public EstatisticaResponse obterMetricas() {
        OffsetDateTime ultimos60segundos = OffsetDateTime.now().minusSeconds(60);
       List<Transacao> transacoesFiltradas = service.getTransacoes().stream().filter(t -> t.getDataHora().isAfter(ultimos60segundos)).toList();

        DoubleSummaryStatistics estatisticas = transacoesFiltradas.stream().mapToDouble(Transacao::getValor).summaryStatistics();

        double min = estatisticas.getCount() > 0 ? estatisticas.getMin() : 0.0;
        double max = estatisticas.getCount() > 0 ? estatisticas.getMax() : 0.0;

        return new EstatisticaResponse(estatisticas.getCount(), estatisticas.getSum(), estatisticas.getAverage(), min, max);
    }
}
