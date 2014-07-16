package fila;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import listas.array.Aluno;
import listas.array.AlunoLinkedListBuilder;

import org.junit.Test;

public class FilaTest {

	@Test
	public void deveRetirarOPrimeiroElementoDaFila() {
		Fila<Aluno> fila = new Fila<>();
		
		AlunoLinkedListBuilder builder = new AlunoLinkedListBuilder();
		LinkedList<Aluno> alunos = builder.build(10).cria();
		
		for (Aluno aluno : alunos) {
			fila.insere(aluno);
		}
		
		fila.remove();
		
		assertEquals("Aluno1", fila.pegaPrimeiro().getNome()); // o indice inicia do 0, portanto o "Aluno1" na verdade era o segundo da Fila.
	}
	
}
