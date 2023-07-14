public class Main {
    public static void main(String[] args) {
        TreinoClassAbstract inicio = new TreinoNoInicioDaTemporada();
        inicio.treinoDiario();

        System.out.println("=============");

        TreinoClassAbstract meio = new TreinoMeioDaTemporada();
        meio.treinoDiario();
    }
}
