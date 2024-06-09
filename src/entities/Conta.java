package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Transacoes {

    private Pessoa titular;
    protected double saldo;

    private List<String> extrato = new ArrayList<>();

    public Conta(Pessoa titular) {
        this.titular = titular;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public abstract void gerarExtrato();

    public abstract void calcularRendimento(int qtdMeses);
}