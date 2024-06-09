package entities;

public class ContaCorrente extends Conta {

    private final double TAXA_SAQUE = 0.03;

    public ContaCorrente(Pessoa titular) {
        super(titular);
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
            double calcTaxaSaque = valor * TAXA_SAQUE;
            System.out.println("Valor da taxa de saque: " + calcTaxaSaque);
            valor -= calcTaxaSaque;
            getExtrato().add("Saque             " + valor);
        }
    }

    @Override
    public void calcularRendimento(int qtdMeses) {
        System.out.println("Não é possivel realizar investimentos na conta corrente");
    }

    @Override
    public void gerarExtrato() {
        System.out.println("      E X T R A T O  B A N C Á R I O      ");
        System.out.println("------------------------------------------");
        System.out.println("Instituição: NUBANK");
        System.out.println("Titular: ");
        System.out.println(getTitular());
        System.out.println("Tipo da conta: Conta Corrente");
        System.out.println("Taxa de saque: " + TAXA_SAQUE * 100 + "%");
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
