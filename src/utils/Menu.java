package utils;

import entities.*;
import pagamentos.Boleto;
import pagamentos.PIX;

import java.util.ArrayList;
import java.util.List;

import static app.Main.sc;

public class Menu {

    public static final String ANSI_BACKGROUND_PURPLE = "\u001B[45m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static List<Conta> contas = new ArrayList<>();

    public static void exibir() {
        logoNubank();
        System.out.println("Pressione qualquer tecla para continuar...");
        sc.nextLine();
        limparTela();

        int escolha = 0;

        do {
            System.out.println("Escolha uma das opções:\n");

            System.out.println("1 - Criar Nova Conta");
            System.out.println("2 - Acessar Contas Existentes");
            System.out.println("3 - Encerrar");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    int tipoConta, tipoPessoa;

                    System.out.println("Deseja criar uma conta:\n");
                    System.out.println("1 - Conta Poupança");
                    System.out.println("2 - Conta Corrente");
                    tipoConta = sc.nextInt();
                    while (tipoConta != 1 & tipoConta != 2) {
                        System.out.print("Valor inválido, tente novamente: ");
                        tipoConta = sc.nextInt();
                    }

                    System.out.println("O titular da conta será: \n");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    tipoPessoa = sc.nextInt();
                    while (tipoPessoa != 1 & tipoPessoa != 2) {
                        System.out.print("Valor inválido, tente novamente: ");
                        tipoPessoa = sc.nextInt();
                    }

                    Pessoa p1;

                    if (tipoPessoa == 1) {
                        p1 = PessoaFisica.criarPessoaFisica();
                    } else {
                        p1 = PessoaJuridica.criarPessoaJuridica();
                    }

                    // caso a conta seja poupança o usuário informa a taxa de rendimento, caso não ele apenas cria uma conta corrente

                    if (tipoConta == 1) {
                        System.out.print("Informe a taxa de rendimento mensal da conta poupança em porcentagem: ");
                        double taxa = sc.nextDouble();

                        contas.add(new ContaPoupanca(p1, taxa));
                    } else {
                        contas.add(new ContaCorrente(p1));
                    }
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    int i = 0;

                    System.out.println("\nNúmero da Conta | Tipo da Conta | Nome do Titular");
                    for (Conta c : contas) {
                        System.out.println(i + "               | " + c.getClass().getSimpleName() + " | " + c.getTitular().getNome());
                        i++;
                    }

                    System.out.print("Escolha o número da conta: ");
                    int nConta = sc.nextInt();

                    if (nConta < 0 | nConta > contas.size() - 1) {
                        System.out.println("Número de conta inválido");
                        break;
                    }

                    Conta c1 = contas.get(nConta);

                    int escolha2;
                    do {
                        System.out.println("Escolha uma das opções:\n");
                        System.out.println("0 - Encerrar");
                        System.out.println("1 - Sacar");
                        System.out.println("2 - Depositar");
                        System.out.println("3 - Gerar Extrato");
                        System.out.println("4 - Calcular Rendimento");
                        System.out.println("5 - Realizar Pagamento");

                        escolha2 = sc.nextInt();

                        switch (escolha2) {
                            case 0 -> System.out.println();
                            case 1 -> efetuarSaque(c1);
                            case 2 -> efetuarDeposito(c1);
                            case 3 -> c1.gerarExtrato();
                            case 4 -> calcRendimento(c1);
                            case 5 -> realizarPagamento();
                            default -> System.out.println("Opção inválida");
                        }

                    } while (escolha2 != 0);

                    break;
                case 3:
                    break;
            }
        } while (escolha != 3);
    }

    private static void realizarPagamento() {
        System.out.print("Informe o valor do pagamento: ");
        double valor = sc.nextDouble();

        System.out.println("Informe a forma de pagamento");
        System.out.println("1 - PIX");
        System.out.println("2 - Boleto");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> new PIX().realizarPagamento(valor);
            case 2 -> new Boleto().realizarPagamento(valor);
        }
    }

    private static void efetuarSaque(Conta c1) {
        System.out.print("Digite o valor: ");
        double valor = sc.nextDouble();
        c1.sacar(valor);
    }

    private static void efetuarDeposito(Conta c1) {
        System.out.print("Digite o valor: ");
        double valor = sc.nextDouble();
        c1.depositar(valor);
    }

    private static void calcRendimento(Conta c1) {
        System.out.println("Digite a quantidade de mêses: ");
        int qtdMeses = sc.nextInt();
        c1.calcularRendimento(qtdMeses);
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void logoNubank() {
        System.out.println(ANSI_BACKGROUND_PURPLE);
        System.out.println("  ..............................................................");
        System.out.println("  ..............................................................");
        System.out.println("  ................:+*####*+:.....******:.........-*****=........");
        System.out.println("  ...........:=*+.:-+#######*:...######-.........=#####+........");
        System.out.println("  .........=###+......-*######-..######-.........=#####+........");
        System.out.println("  .......:#####:........*#####+:.######-.........=#####+........");
        System.out.println("  .......*####*:........:######:.######-.........=#####+........");
        System.out.println("  ......:#####*:.........######:.######-.........=#####+........");
        System.out.println("  ......:#####*:.........######:.######-.........=#####+........");
        System.out.println("  ......:#####*:.........######:.######-.........=#####+........");
        System.out.println("  ......:#####*:.........######:.######-.........=#####+........");
        System.out.println("  ......:#####*:.........######:.######-.........=#####+........");
        System.out.println("  ......:#####*:.........######:.-######.........=#####:........");
        System.out.println("  ......:#####*:.........######:..######*........*####-.........");
        System.out.println("  ......:#####*:.........######:..:#######=.....+##*-...........");
        System.out.println("  ......:#####*:.........######:...:+########*=::...............");
        System.out.println("  .......::::::..........::::::.......-=+*+=-...................");
        System.out.println("  ..............................................................");
        System.out.println("  ..............................................................");
        System.out.println(ANSI_RESET);
    }
}
