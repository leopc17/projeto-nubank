package entities;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca implements Conta {

    private Pessoa titular;
    private double saldo;
    private double taxaRendimentoMensal;
    private int senha;

    private List<String> extrato = new ArrayList<>();

    public ContaPoupanca(Pessoa titular, int senha, double taxaRendimentoMensal) {
        this.titular = titular;
        this.senha = senha;
        this.taxaRendimentoMensal = taxaRendimentoMensal;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaRendimentoMensal() {
        return taxaRendimentoMensal;
    }

    public void setTaxaRendimentoMensal(double taxaRendimentoMensal) {
        this.taxaRendimentoMensal = taxaRendimentoMensal;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public boolean verificarSenha(int senha) {
        return this.senha == senha;
    }

    public void calcularRendimento(int qtdMeses) {
        double juros;

        if (qtdMeses > 0) {
            juros = saldo - (saldo * qtdMeses * taxaRendimentoMensal);
            saldo += juros;
            System.out.println("Juros: " + juros);
            System.out.println("Novo Saldo: " + saldo);
        } else {
            System.out.println("A quantidade de mêses deve ser um valor positivo");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor < 0) {
            System.out.println("valor de saque inválido");
        } else {
            saldo += valor;
            extrato.add("Depósito no valor de: " + valor);
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo || valor < 0) {
            System.out.println("valor de saque inválido");
        } else {
            saldo -= valor;
            extrato.add("Saque no valor de: " + valor);
        }
    }

    @Override
    public void gerarExtrato() {
        System.out.println("      E X T R A T O  B A N C Á R I O      ");
        System.out.println("------------------------------------------");
        System.out.println("Instituição: NUBANK");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Tipo da conta: Conta Poupança");
        System.out.println("Taxa de Rendimento Mensal: " + taxaRendimentoMensal + "%");
        System.out.println("------------------------------------------");
        System.out.println("HISTÓRICO                            VALOR");
        System.out.println("------------------------------------------");
        for (String s : extrato) {
            System.out.println(s);
        }
    }

    @Override
    public String gerarResumo() {
        return "Conta Poupança | " + titular.getNome();
    }
}
