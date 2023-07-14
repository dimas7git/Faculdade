package exPilha;
import java.util.*;
public class Pilha<T> {
	private ArrayList<T> pilha = new ArrayList<T>();
	public void empilhar(T t) {
		pilha.add(t);
	}
	
	public void desimpilhar() throws RuntimeException{
		pilha.remove(pilha.size() -1 );	
		return ;
		}
	
	
	public boolean vazio(T t) {
		return pilha.size() == 0;
	}
	
	public ArrayList<T> getPilha(){
		return this.pilha;
	} 
}
