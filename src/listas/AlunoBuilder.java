package listas;


public class AlunoBuilder {

	Vetor alunos = new Vetor();
	
	public AlunoBuilder build(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			alunos.adiciona(new Aluno("Aluno"+i));
		}
		return this;
	}
	
	public Vetor cria() {
		return alunos;
	}
	
}
