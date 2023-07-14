package exFila;

import exPilha.Pilha;

public class main {
	public static void main(String args[]) {
		       Fila<String> f = new Fila<String>();
		       
		       f.empilhar("Dimas");
		       f.empilhar("Caio");
		       f.empilhar("Andre");
		       f.empilhar("Pero");
		       
		       System.out.println("Apresentação de nomes: " + f.getPilha());
		       
		       f.desimpilhar();
		       System.out.println("Desimpilhou o ultimo nome inserido na pilha " + f.getPilha());
		       
		       f.desimpilhar();
		       System.out.println("Desimpilhou o ultimo nome inserido na pilha " + f.getPilha());
		       
		       f.desimpilhar();
		       System.out.println("Desimpilhou o ultimo nome inserido na pilha " + f.getPilha());
		    
	}
}
