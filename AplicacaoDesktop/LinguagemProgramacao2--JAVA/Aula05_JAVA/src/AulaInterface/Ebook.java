package AulaInterface;

public class Ebook implements AulaInterface{

    @Override
    public String descricao() {
         return "Exemplo descricao";
    }

    @Override
    public int ListarPreco() {
         return 3000;
    }

    @Override
    public int MenorPreco() {
            return 20;
    }

    public Ebook() {
    }
    
}
