package listas.array;

import java.util.LinkedList;


public class AlunoLinkedListBuilder {

	LinkedList<Aluno> alunos = new LinkedList<>();
	
	public AlunoLinkedListBuilder build(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			alunos.add(new Aluno("Aluno"+i));
		}
		return this;
	}
	
	public LinkedList<Aluno> cria() {
		return alunos;
	}
	
}
