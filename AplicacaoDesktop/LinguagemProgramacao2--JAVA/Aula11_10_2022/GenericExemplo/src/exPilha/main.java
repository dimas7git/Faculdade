package exPilha;

public class main {
	public static void main(String args[]) {
       Pilha<String> p = new Pilha<String>();
       
       p.empilhar("Dimas");
       p.empilhar("Caio");
       p.empilhar("Andre");
       p.empilhar("Pero");
       
       System.out.println("Apresentação de nomes: " + p.getPilha());
       
       p.desimpilhar();
       System.out.println("Desimpilhou o ultimo nome inserido na pilha " + p.getPilha());
       
       p.desimpilhar();
       System.out.println("Desimpilhou o ultimo nome inserido na pilha " + p.getPilha());
       
       p.desimpilhar();
       System.out.println("Desimpilhou o ultimo nome inserido na pilha " + p.getPilha());
    }
}
