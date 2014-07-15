package listas.array;


public class Vetor {

	// declarando e inicializando um array de Aluno com capacidade 100.
	private Object[] objetos = new Object[100];
	private int totalDeObjetos = 0;

	/**
	 * 
	 * 
	 * 
	 * Adiciona um novo aluno na ultima posicao
	 * @param aluno
	 */
	public void adiciona(Object objeto) {
		this.garantaEspaco();
		objetos[totalDeObjetos] = objeto;
		this.totalDeObjetos++;
	}

	/**
	 * 
	 * 
	 * 
	 * Adiciona um novo aluno em uma posicao escolhida
	 * @param posicao
	 * @param aluno
	 */
	public void adiciona(int posicao, Object objeto) {
		this.garantaEspaco();
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		
		for (int i = totalDeObjetos - 1; i >= posicao; i-=1) {
			objetos[i + 1] = objetos[i];
		}
		
		objetos[posicao] = objeto;
		totalDeObjetos++;
	}

	/**
	 * 
	 * 
	 * 
	 * Retorna o aluno na posicao passada
	 * @param posicao
	 * @return
	 */
	public Object pega(int posicao) {
		if (objetos[posicao] != null) {
			return objetos[posicao];
		}
		throw new IllegalArgumentException("Posição inválida");
	}

	/**
	 * 
	 * 
	 * 
	 * Remove o aluno na posicao passada
	 * @param posicao
	 */
	public void remove(int posicao) {
		if(!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		for (int i = posicao; i < objetos.length -1; i++) {
			objetos[i] = objetos[i + 1];			
		}
		
		totalDeObjetos--;
	}

	/**
	 * 
	 * 
	 * 
	 * Verifica se o aluno existe na lista
	 * @param aluno
	 * @return
	 */
	public boolean contem(Object objeto) {
		for (int i = 0; i < totalDeObjetos; i++) {
			if (objeto.equals(objetos[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 
	 * 
	 * Retorna o numero total de alunos
	 * @return
	 */
	public int tamanho() {
		return totalDeObjetos;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Metodo privado que retorna se uma posicao no array e ou nao valida.
	 * @param posicao
	 * @return
	 */
	private boolean isPosicaoValida(int posicao) {
		return posicao >=0 && posicao <= totalDeObjetos;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Garante que quando o array for completamente preenchido ele terá
	 * seu tamanho dobrado.
	 */
	private void garantaEspaco() {
		if (totalDeObjetos == objetos.length) {
			Object[] novaArray = new Object[objetos.length * 2];
			for (int i = 0; i < objetos.length; i++) {
				novaArray[i] = objetos[i];
			}
			objetos = novaArray;
		}
	}

	/**
	 * 
	 * 
	 * 
	 * Sobrescrita do metodo toString()
	 */
	@Override
	public String toString() {
		if (totalDeObjetos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < totalDeObjetos - 1; i++) {
			builder.append(objetos[i]);
			builder.append(", ");
		}

		builder.append(objetos[totalDeObjetos - 1]);
		builder.append("]");

		return builder.toString();
	}

}
