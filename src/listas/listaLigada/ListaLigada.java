package listas.listaLigada;

public class ListaLigada {

	private Celula primeira;
	
	private Celula ultima;
	
	int totalDeElementos;

	/**
	 * 
	 * 
	 * 
	 * Adiciona um elmeento no final da lista
	 * @param elemento
	 */
	public void adiciona(Object elemento) {
		if (totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento, null);
			ultima.setProxima(nova);
			ultima = nova;
			totalDeElementos++;
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * Adiciona um elemento na posicao passada como argumento
	 * @param posicao
	 * @param elemento
	 */
	public void adiciona(int posicao, Object elemento) {
		if (posicao == 0) {
			this.adicionaNoComeco(elemento);
		} else if (posicao == totalDeElementos) {
			adiciona(elemento);
		} else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula nova = new Celula(elemento, anterior.getProxima());
			anterior.setProxima(nova);
			totalDeElementos++;
		}
	}
	public Object pega(int posicao) {return null;}
	public void remove(int posicao) {}
	public int tamanho() {return 0;}
	public boolean conte(Object elemento) {return false;}

	/**
	 * 
	 * 
	 * 
	 * Adiciona um elmeento no comeco da lista
	 * @param elemento
	 */
	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, primeira);
		primeira = nova;
		
		if(totalDeElementos == 0) {
			ultima = primeira;
		}
		
		totalDeElementos++;
	}
	
	public void removeDoComeco() {}
	public void removeDoFim() {}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalDeElementos;
	}
	
	private Celula pegaCelula(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao nao existe");
		}
		
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();
		}
		
		return atual;
	}
	
	@Override
	public String toString() {
		// verificando se a lista está vazia
		if (totalDeElementos == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;
		
		// percorrendo até o penultimo elemento.
		while (atual != null) {
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProxima();
		}
		
		// ultimo elemento
		atual = ultima;
		builder.append("]");
		
		return builder.toString();
	}
	
}