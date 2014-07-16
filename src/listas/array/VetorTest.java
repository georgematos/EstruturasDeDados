package listas.array;

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

		assertEquals("George", ((Aluno) lista.pega(0)).getNome());
		assertEquals("Livia", ((Aluno) lista.pega(1)).getNome());
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
		
		AlunoVetorBuilder builder = new AlunoVetorBuilder();
		
		lista = builder.build(5).cria();

		Aluno alunoRetornado = (Aluno) lista.pega(1);
		
		assertEquals("Aluno1", alunoRetornado.getNome());
		assertEquals(5, lista.tamanho());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRetornaExcecaoCasoPosicaoNaoEstejaOcupada() {
		Vetor lista = new Vetor();
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno.setNome("George");
		aluno2.setNome("Livia");

		lista.pega(2);
	}
	
	@Test
	public void deveAdicionarUmAlunoEmUmaPosicaoEspecifica() {
		Vetor lista = new Vetor();
		AlunoVetorBuilder builder = new AlunoVetorBuilder();
		lista = builder.build(5).cria();
				
		lista.adiciona(2, new Aluno("George"));
		
		assertEquals("George", ((Aluno) lista.pega(2)).getNome());
	}
	
	@Test
	public void deveRemoverOAlunoDaPosicaoPassadaEDeslocarOsDaDiretaParaPreencherOEsapacoVazio() {
		Vetor lista = new Vetor();
		AlunoVetorBuilder builder = new AlunoVetorBuilder();
		lista = builder.build(5).cria();
		
		lista.remove(1); // remove o Aluno1
		
		assertEquals("Aluno2", ((Aluno) lista.pega(1)).getNome()); // caso tudo saia ok, o aluno 2 deve estar agora na posicao 1
		assertEquals(4, lista.tamanho()); // e o tamanho do array dever ser 4
	}

}
