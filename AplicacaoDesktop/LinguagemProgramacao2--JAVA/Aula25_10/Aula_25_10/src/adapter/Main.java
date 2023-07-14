package adapter;

public class Main {
    public static void main(String[] args) {
        CotacaoAdapter cotacao = new CotacaoAdapter();
        cotacao.setValor(11.00);

        System.out.println("R$ " + cotacao.getValor());
        System.out.println("U$ " + cotacao.getValorDolar());
    }
}
