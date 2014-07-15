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
	
	/**
	 * 
	 * 
	 * 
	 * Busca e retorna o elemento na posicao passada como argumento
	 * @param posicao
	 * @return
	 */
	public Object pega(int posicao) {
		return pegaCelula(posicao).getElemento();
	}
	
	/**
	 * 
	 * 
	 * 
	 * Removendo elemento de qualquer posicao
	 * @param posicao
	 */
	public void remove(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao nao existe");
		}
		
		if (posicao == 0) {
			removeDoComeco();
		} else if (posicao == totalDeElementos - 1) {
			removeDoFim();
		} else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula atual = anterior.getProxima();
			Celula proxima = atual.getProxima();
			
			anterior.setProxima(proxima);
			proxima.setAnterior(anterior);
			
			totalDeElementos--;
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * Deve retornar o tamanho da lista
	 * @return
	 */
	public int tamanho() {
		return totalDeElementos;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Verifica se o elemento existe na lista
	 * @param elemento
	 * @return
	 */
	public boolean contem(Object elemento) {
		
		Celula atual = primeira;
		
		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			
			atual = atual.getProxima();
		}
		
		return false;
	}

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
	
	/**
	 * 
	 * 
	 * Remove o elemento do comeco da lista
	 */
	public void removeDoComeco() {
		if (!posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao não existe");
		}
		
		primeira = primeira.getProxima();
		totalDeElementos--;
		
		if (totalDeElementos == 0) {
			ultima = null;
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * Remove elemento do fim da lista
	 */
	public void removeDoFim() {
		
		if (!posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao nao existe");
		}
		
		if (totalDeElementos == 1) {
			removeDoComeco();
		} else {
			Celula penultima = ultima.getAnterior();
			penultima.setProxima(null);
			ultima = penultima;
			totalDeElementos--;
		}
		
		ultima = null;

		Celula atual = primeira;
		
		for (int i = 0; i < totalDeElementos - 1; i++) {
			atual = atual.getProxima();
		}
		ultima = atual;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Verifica se a posicao requerida esta ou nao ocupada
	 * @param posicao
	 * @return
	 */
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalDeElementos;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Retorna a celula na posicao requerida
	 * @param posicao
	 * @return
	 */
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
	
	/**
	 * 
	 * 
	 * 
	 * Sobrescreve o metodo toString para exibir os elementos da lista.
	 */
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