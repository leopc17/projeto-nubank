package entities;

import static app.Main.*;

public class PessoaFisica extends Pessoa {
    private String CPF;

    public PessoaFisica(String nome, String endereco, String CPF) {
        super(nome, endereco);
        this.CPF = CPF;
    }

    public static PessoaFisica criarPessoaFisica() {
        System.out.println("Digite os dados da Pessoa Fisica: ");
        System.out.print("Nome: ");
        String nome = scString.nextLine();
        System.out.print("Endereço: ");
        String endereco = scString.nextLine();
        System.out.print("CPF: ");
        String CPF = scString.nextLine();

        return new PessoaFisica(nome, endereco, CPF);
    }

    @Override
    public void imprimirInfos() {
        System.out.println(getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("CPF: " + CPF);
    }
}
