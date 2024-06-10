package pagamentos;

import java.time.LocalDate;

import static app.Main.sc;

public class PIX implements Pagamento {

    private double valor;

    @Override
    public void realizarPagamento(double valor) {
        this.valor = valor;
        System.out.println("Realizando PIX...");
        System.out.println("Deseja imprimir o comprovante? 1 - Sim \n 2 - Não \n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> gerarComprovante();
            default -> System.out.println("Pagamento Realizado com sucesso!");
        }
    }

    @Override
    public void gerarComprovante() {
        LocalDate dataAtual = LocalDate.now();

        System.out.println("------------------------");
        System.out.println("      Comprovante       ");
        System.out.println("------------------------");
        System.out.println("Data: " + dataAtual);
        System.out.println("Valor: " + valor);
        System.out.println("------------------------");
    }
}
