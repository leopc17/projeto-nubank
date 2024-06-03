package entities;

public interface Conta {
    void depositar(double valor);
    void sacar(double valor);
    void gerarExtrato();
    String gerarResumo();
}
