package exFila;

import java.util.*;

public class Fila<T> {
	private ArrayList<T> fila = new ArrayList<T>();
	public void empilhar(T t) {
		fila.add(t);
	}
	
	public void desimpilhar() throws RuntimeException{
		fila.remove(0);	
		return ;
		}
	
	
	public boolean vazio(T t) {
		return fila.size() == 0;
	}
	
	public ArrayList<T> getPilha(){
		return this.fila;
	} 
}
