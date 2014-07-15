package listas;

public class Vetor {

	// declarando e inicializando um array de Aluno com capacidade 100.
	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;

	/**
	 * 
	 * 
	 * 
	 * Adiciona um novo aluno na ultima posicao
	 * @param aluno
	 */
	public void adiciona(Aluno aluno) {
		this.garantaEspaco();
		alunos[totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	/**
	 * 
	 * 
	 * 
	 * Adiciona um novo aluno em uma posicao escolhida
	 * @param posicao
	 * @param aluno
	 */
	public void adiciona(int posicao, Aluno aluno) {
		this.garantaEspaco();
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		
		for (int i = totalDeAlunos - 1; i >= posicao; i-=1) {
			alunos[i + 1] = alunos[i];
		}
		
		alunos[posicao] = aluno;
		totalDeAlunos++;
	}

	/**
	 * 
	 * 
	 * 
	 * Retorna o aluno na posicao passada
	 * @param posicao
	 * @return
	 */
	public Aluno pega(int posicao) {
		if (alunos[posicao] != null) {
			return alunos[posicao];
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
		
		for (int i = posicao; i < alunos.length -1; i++) {
			alunos[i] = alunos[i + 1];			
		}
		
		totalDeAlunos--;
	}

	/**
	 * 
	 * 
	 * 
	 * Verifica se o aluno existe na lista
	 * @param aluno
	 * @return
	 */
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalDeAlunos; i++) {
			if (aluno.equals(alunos[i])) {
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
		return totalDeAlunos;
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
		return posicao >=0 && posicao <= totalDeAlunos;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Garante que quando o array for completamente preenchido ele terá
	 * seu tamanho dobrado.
	 */
	private void garantaEspaco() {
		if (totalDeAlunos == alunos.length) {
			Aluno[] novaArray = new Aluno[alunos.length * 2];
			for (int i = 0; i < alunos.length; i++) {
				novaArray[i] = alunos[i];
			}
			alunos = novaArray;
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
		if (totalDeAlunos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < totalDeAlunos - 1; i++) {
			builder.append(alunos[i]);
			builder.append(", ");
		}

		builder.append(alunos[totalDeAlunos - 1]);
		builder.append("]");

		return builder.toString();
	}

}
