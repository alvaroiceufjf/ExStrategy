package org.example;

public class CalculoRendimentoRDCPos implements CalculoRendimento {

    private double taxaCdiMensal;

    public CalculoRendimentoRDCPos(double taxaCdiMensal) {
        this.taxaCdiMensal = taxaCdiMensal;
    }

    @Override
    public double calcular(double valorAplicado, int meses) {
        // Juros compostos com base no CDI
        return valorAplicado * Math.pow(1 + taxaCdiMensal, meses) - valorAplicado;
    }
}
