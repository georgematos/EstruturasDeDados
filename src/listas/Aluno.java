package listas;


public class Aluno {

	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método sobrescrito para retornar o nome do aluno
	 * será útil para imprimir os alunos na tela.
	 */
	public String toString() {
		return this.nome;
	}
	
	/**
	 * Método sobrescrito para alterar o critério de comparação
	 * dos objetos para o nome do aluno.
	 */
	public boolean equals(Object o) {
		if(o instanceof Aluno && ((Aluno) o).getNome() != null) {
			Aluno outro = (Aluno) o;
			return this.nome.equals(outro.nome);
		} else {
			return false;
		}
	}
	
}
