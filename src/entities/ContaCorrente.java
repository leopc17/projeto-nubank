package entities;

public class ContaCorrente extends Conta {

    public ContaCorrente(Pessoa titular, int senha) {
        super(titular, senha);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        getExtrato().add("Depósito             " + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo || valor < 0) {
            System.out.println("valor de saque inválido");
        } else {
            saldo -= valor;
            double taxaSaque = valor * 3 / 100;
            System.out.println("Taxa de saque: " + taxaSaque);
            valor -= taxaSaque;
            getExtrato().add("Saque             " + valor);
        }
    }

    @Override
    public void gerarExtrato() {
        System.out.println("      E X T R A T O  B A N C Á R I O      ");
        System.out.println("------------------------------------------");
        System.out.println("Instituição: NUBANK");
        System.out.print("Titular: ");
        getTitular().imprimirInfos();
        System.out.println("Tipo da conta: Conta Corrente");
        System.out.println("------------------------------------------");
        System.out.println("HISTÓRICO                            VALOR");
        System.out.println("------------------------------------------");
        for (String s : getExtrato()) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------");
        System.out.println("Saldo atual: " + saldo);
        System.out.println();
    }
}
