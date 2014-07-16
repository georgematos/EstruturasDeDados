package fila;

import java.util.LinkedList;

public class Fila<T> {

	LinkedList<T> objetos = new LinkedList<>();
	
	public void insere(T t) {
		objetos.add(t);
	}
	
	public T remove() {
		return objetos.removeFirst();
	}
	
	public boolean isVazia() {
		return objetos.isEmpty();
	}
	
	public T pegaPrimeiro() {
		return objetos.getFirst();
	}
	
	public int tamanho() {
		return objetos.size();
	}
	
}
