package entities;

import static app.Main.*;

public class PessoaJuridica extends Pessoa {
    private String CNPJ;

    public PessoaJuridica(String nome, String endereco, String CNPJ) {
        super(nome, endereco);
        this.CNPJ = CNPJ;
    }

    public static PessoaJuridica criarPessoaJuridica() {
        System.out.println("Digite os dados da Pessoa Fisica: ");
        System.out.print("Nome: ");
        String nome = scString.nextLine();
        System.out.print("Endereço: ");
        String endereco = scString.nextLine();
        System.out.print("CNPJ: ");
        String CNPJ = scString.nextLine();

        return new PessoaJuridica(nome, endereco, CNPJ);
    }

    @Override
    public String toString() {
        return super.toString()
                + "CNPJ: " + CNPJ + "\n";
    }
}
