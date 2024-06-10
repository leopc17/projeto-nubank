package pagamentos;

import java.time.LocalDate;

import static app.Main.sc;

public class Boleto implements Pagamento {

    private double TAXA_EMISSAO = 2.30;

    private double valor;

    @Override
    public void realizarPagamento(double valor) {
        valor -= TAXA_EMISSAO;
        this.valor = valor;

        System.out.println("Gerando Boleto...");
        System.out.println("Taxa de emissão do boleto: " + TAXA_EMISSAO + " R$");
        System.out.println("Deseja imprimir o comprovante?\n1 - Sim \n2 - Não \n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> gerarComprovante();
            default -> System.out.println("Pagamento Realizado com sucesso!");
        }
    }

    @Override
    public void gerarComprovante() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataVencimento = dataAtual.plusDays(30);

        System.out.println("------------------------");
        System.out.println("      Comprovante       ");
        System.out.println("------------------------");
        System.out.println("Data de emissão: " + dataAtual);
        System.out.println("Data de vencimento: " + dataVencimento);
        System.out.println("Valor: " + valor);
        System.out.println("------------------------");
    }
}
