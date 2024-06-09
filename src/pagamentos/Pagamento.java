package pagamentos;

public interface Pagamento {
    void realizarPagamento(double valor);
    void gerarComprovante();
}
