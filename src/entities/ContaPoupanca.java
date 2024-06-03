package entities;

public class ContaPoupanca extends Conta {

    private double taxaRendimentoMensal;

    public ContaPoupanca(Pessoa titular, int senha, double taxaRendimentoMensal) {
        super(titular, senha);
        this.taxaRendimentoMensal = taxaRendimentoMensal;
    }

    public void calcularRendimento(int qtdMeses) {
        double juros;

        if (qtdMeses > 0) {
            juros = getSaldo() * qtdMeses * taxaRendimentoMensal / 100;
            saldo += juros;
            System.out.println("Juros: " + juros);
            System.out.println("Novo Saldo: " + saldo);
            getExtrato().add("Rendimento do investimento:       " + juros);
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
            getExtrato().add("Depósito no valor de:             " + valor);
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo || valor < 0) {
            System.out.println("valor de saque inválido");
        } else if (valor > 5000) {
            System.out.println("O limite de saque para contas poupança é de R$ 5000");
        } else {
            saldo -= valor;
            getExtrato().add("Saque no valor de:             " + valor);
        }
    }

    @Override
    public void gerarExtrato() {
        System.out.println("      E X T R A T O  B A N C Á R I O      ");
        System.out.println("------------------------------------------");
        System.out.println("Instituição: NUBANK");
        System.out.println("Titular: " + getTitular().getNome());
        System.out.println("Tipo da conta: Conta Poupança");
        System.out.println("Taxa de Rendimento Mensal: " + taxaRendimentoMensal + "%");
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
