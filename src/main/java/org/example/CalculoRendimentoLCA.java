package org.example;

public class CalculoRendimentoLCA implements CalculoRendimento {

    private double taxaFixaMensal;

    public CalculoRendimentoLCA(double taxaFixaMensal) {
        this.taxaFixaMensal = taxaFixaMensal;
    }

    @Override
    public double calcular(double valorAplicado, int meses) {
        // Rentabilidade isenta de IR com taxa prefixada
        return valorAplicado * Math.pow(1 + taxaFixaMensal, meses) - valorAplicado;
    }
}
