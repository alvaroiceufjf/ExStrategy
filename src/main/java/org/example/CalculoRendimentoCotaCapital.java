package org.example;


public class CalculoRendimentoCotaCapital implements CalculoRendimento {

    private double taxaJurosMensal;

    public CalculoRendimentoCotaCapital(double taxaJurosMensal) {
        this.taxaJurosMensal = taxaJurosMensal;
    }

    @Override
    public double calcular(double valorAplicado, int meses) {
        // Juros simples creditados sobre a cota capital do associado
        return valorAplicado * taxaJurosMensal * meses;
    }
}