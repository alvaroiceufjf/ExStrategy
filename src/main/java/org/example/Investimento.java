package org.example;

public class Investimento {

    private double valorAplicado;
    private int meses;
    private CalculoRendimento calculoRendimento;

    public Investimento(double valorAplicado, int meses, CalculoRendimento calculoRendimento) {
        this.valorAplicado = valorAplicado;
        this.meses = meses;
        this.calculoRendimento = calculoRendimento;
    }

    public void setCalculoRendimento(CalculoRendimento calculoRendimento) {
        this.calculoRendimento = calculoRendimento;
    }

    public double calcularRendimentoTotal() {
        return this.calculoRendimento.calcular(this.valorAplicado, this.meses);
    }

    public double getValorAplicado() {
        return valorAplicado;
    }

    public int getMeses() {
        return meses;
    }
}
