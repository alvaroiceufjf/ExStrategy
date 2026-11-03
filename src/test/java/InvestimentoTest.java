package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvestimentoTest {

    @Test
    void deveCalcularRendimentoRDCPos() {
        // CDI de 1% a.m. (0.01) por 12 meses em R$ 10.000
        CalculoRendimento strategyRDC = new CalculoRendimentoRDCPos(0.01);
        Investimento investimento = new Investimento(10000.0, 12, strategyRDC);

        double rendimentoEsperado = 10000.0 * Math.pow(1.01, 12) - 10000.0;
        assertEquals(rendimentoEsperado, investimento.calcularRendimentoTotal(), 0.01);
    }

    @Test
    void deveCalcularRendimentoCotaCapital() {
        // Taxa de 0.8% a.m. (0.008) por 10 meses em R$ 5.000
        CalculoRendimento strategyCota = new CalculoRendimentoCotaCapital(0.008);
        Investimento investimento = new Investimento(5000.0, 10, strategyCota);

        // 5000 * 0.008 * 10 = 400.0
        assertEquals(400.0, investimento.calcularRendimentoTotal(), 0.01);
    }

    @Test
    void deveCalcularRendimentoLCA() {
        // Taxa fixa de 0.9% a.m. (0.009) por 6 meses em R$ 20.000
        CalculoRendimento strategyLCA = new CalculoRendimentoLCA(0.009);
        Investimento investimento = new Investimento(20000.0, 6, strategyLCA);

        double rendimentoEsperado = 20000.0 * Math.pow(1.009, 6) - 20000.0;
        assertEquals(rendimentoEsperado, investimento.calcularRendimentoTotal(), 0.01);
    }

    @Test
    void devePermitirTrocarEstrategiaEmTempoDeExecucao() {
        CalculoRendimento strategyRDC = new CalculoRendimentoRDCPos(0.01);
        Investimento investimento = new Investimento(10000.0, 10, strategyRDC);

        // Altera a estratégia dinamicamente para Cota Capital
        CalculoRendimento strategyCota = new CalculoRendimentoCotaCapital(0.008);
        investimento.setCalculoRendimento(strategyCota);

        assertEquals(800.0, investimento.calcularRendimentoTotal(), 0.01);
    }
}