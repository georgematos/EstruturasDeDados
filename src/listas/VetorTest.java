package listas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VetorTest {

	@Test
	public void deveAdicionarNoFim() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno.setNome("George");
		aluno2.setNome("Livia");
		
		lista.adiciona(aluno);
		lista.adiciona(aluno2);
		
		assertEquals("George", lista.pega(0).getNome());
		assertEquals("Livia", lista.pega(1).getNome());
	}
	
	@Test
	public void deveRetornarOTamanhoDaLista() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno.setNome("George");
		aluno2.setNome("Livia");
		
		lista.adiciona(aluno);
		lista.adiciona(aluno2);
		
		assertEquals(2, lista.tamanho());
	}
	
	@Test 
	public void deveVerificarSeOAlunoEstaPresenteNoVetor() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno.setNome("George");
		aluno2.setNome("Livia");
		
		lista.adiciona(aluno);
		lista.adiciona(aluno2);
		
		assertEquals(true, lista.contem(aluno));
	}
	
	@Test 
	public void deveVerificarSeOAlunoNaoEstaPresenteNoVetor() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno.setNome("George");
		aluno2.setNome("Livia");
		
		lista.adiciona(aluno);
		
		assertEquals(false, lista.contem(aluno2));
	}
	
	@Test
	public void deveRetornarObjetoNaPosicaoPassada() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		aluno.setNome("George");
		
		lista.adiciona(aluno);
		
		Aluno alunoGeorge = lista.pega(0);
		
		assertEquals(aluno, alunoGeorge);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveRetornaExcecaoCasoPosicaoNaoEstejaOcupada() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno.setNome("George");
		aluno2.setNome("Livia");
		
		lista.pega(2);
	}
	
}
