package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Transacoes {

    private Pessoa titular;
    private int senha;
    protected double saldo;

    private List<String> extrato = new ArrayList<>();

    public Conta(Pessoa titular, int senha) {
        this.titular = titular;
        this.senha = senha;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public boolean verificarSenha(int senha) {
        return this.senha == senha;
    }

    public abstract void gerarExtrato();
}