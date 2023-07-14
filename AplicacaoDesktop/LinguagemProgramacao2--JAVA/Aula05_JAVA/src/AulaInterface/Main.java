package AulaInterface;

public class Main {

    public static void main(String[] args) {
        Ebook ebook = new Ebook();
        LivroTradicional livro = new LivroTradicional();

        System.out.println(ebook.descricao());
        System.out.println(ebook.ListarPreco());
        System.out.println(ebook.MenorPreco());
    }
}
