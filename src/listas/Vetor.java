package listas;

public class Vetor {

	// declarando e inicializando um array de Aluno com capacidade 100.
	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;

	public void adiciona(Aluno aluno) {
		alunos[totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	public void adiciona(int posicao, Aluno aluno) {

	}

	public Aluno pega(int posicao) {
		if (alunos[posicao] != null) {
			return alunos[posicao];
		}
		throw new IllegalArgumentException("Posição inválida");
	}

	public void remove(int posicao) {

	}

	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalDeAlunos; i++) {
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return totalDeAlunos;
	}

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
