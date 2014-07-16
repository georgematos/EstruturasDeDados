package pilhas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PilhaTest {

	@Test
	public void deveInserirUmElementoNaPilha() {
		Pilha<Peca> pilha = new Pilha<>();
		Peca peca1 = new Peca("parafuso");
		
		pilha.insere(peca1);
		
		assertTrue(!pilha.isVazia());
	}
	
	@Test
	public void deveRetirarUmElementoDaPilha() {
		Pilha<Peca> pilhaPrincipal = new Pilha<>();
		Pilha<Peca> pilhaSecundaria = new Pilha<>();
		
		Peca peca1 = new Peca("parafuso");
		pilhaPrincipal.insere(peca1); // coloca uma peca na pilha principal
		
		Peca peca2 = pilhaPrincipal.remove(); // retira a peca da pilha principal
		pilhaSecundaria.insere(peca2); // coloca a peca na pilha secundaria
		
		assertTrue(pilhaPrincipal.isVazia());
		assertTrue(!pilhaSecundaria.isVazia());
	}
	
	@Test
	public void aPilhaDeveAceitarUmObjetoParametrizado() {
		Pilha<Integer> pilha = new Pilha<>();
		Integer a = 10;
		Integer b = 10;
		
		pilha.insere(a);
		pilha.insere(b);
		
		assertEquals(2, pilha.tamanho());
	}
	
}
