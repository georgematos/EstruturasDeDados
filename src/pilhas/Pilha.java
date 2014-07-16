package pilhas;

import java.util.LinkedList;

public class Pilha<T> {
	
	//usei uma lista ligada porque em uma pilha só precisarei manipular elementos do topo
	private LinkedList<T> objetos = new LinkedList<>();

	public void insere(T t) {
		objetos.add(t);
	}
	
	public T remove() {
		return objetos.remove(objetos.size() - 1);
	}
	
	public boolean isVazia() {
		return objetos.isEmpty();
	}
	
	public int tamanho() {
		return objetos.size();
	}
	
}
