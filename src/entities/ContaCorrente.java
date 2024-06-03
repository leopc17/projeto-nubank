package entities;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente implements Conta {

    private Pessoa titular;
    private double saldo;
    private int senha;

    private List<String> extrato = new ArrayList<>();

    public ContaCorrente(Pessoa titular, int senha) {
        this.titular = titular;
        this.senha = senha;
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

    public boolean verificarSenha(int senha) {
        return this.senha == senha;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito                             " + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("valor de saque inválido");
        } else {
            saldo -= valor;
            extrato.add("Saque                            " + valor);
        }
    }

    @Override
    public void gerarExtrato() {
        System.out.println("      E X T R A T O  B A N C Á R I O      ");
        System.out.println("------------------------------------------");
        System.out.println("Instituição: NUBANK");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Tipo da conta: Conta Corrente");
        System.out.println("------------------------------------------");
        System.out.println("HISTÓRICO                            VALOR");
        System.out.println("------------------------------------------");
        for (String s : extrato) {
            System.out.println(s);
        }
    }

    @Override
    public String gerarResumo() {
        return "Conta Corrente | " + titular.getNome();
    }
}
