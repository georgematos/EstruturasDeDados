package pilha;

import java.util.Stack;

public class EstudoStack {

	public static void main(String[] args) {
		
		// Cria uma pilha de pecas
		Stack<Peca> pilha = new Stack<>();
		
		// Cria uma peca e coloca na pilha
		Peca pecaInserida = new Peca("corrente");
		pilha.push(pecaInserida);

		
		// Remove a peca da pilha e imprime o nome da peca removida
		Peca pecaRemovida = pilha.pop();					
		System.out.println(pecaRemovida.getNome());
		
		// Verifica se a pilha esta vazia
		if(pilha.isEmpty()) {
			System.out.println("A pilha está vazia");
		}
		
	}
}
