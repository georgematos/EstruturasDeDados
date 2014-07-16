package listas.array;


public class AlunoVetorBuilder {

	Vetor alunos = new Vetor();
	
	public AlunoVetorBuilder build(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			alunos.adiciona(new Aluno("Aluno"+i));
		}
		return this;
	}
	
	public Vetor cria() {
		return alunos;
	}
	
}
