package listas.listaLigada;

import listas.array.Aluno;

import org.junit.Test;

public class ListaLigadaTest {

	@Test
	public void deveAdicionarNoFimDaListaLigada() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("George");
		Aluno aluno2 = new Aluno("Livia");
		Aluno aluno3 = new Aluno("Vanda");
		
		lista.adiciona(aluno1);
		lista.adiciona(aluno2);
		lista.adiciona(aluno3);
		
		System.out.println(lista.toString());
	}
	
	@Test
	public void deveAdicionarNoInicioDaListaLigada() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("George");
		Aluno aluno2 = new Aluno("Livia");
		Aluno aluno3 = new Aluno("Vanda");
		Aluno aluno4 = new Aluno("Ze Maria");
		
		lista.adicionaNoComeco(aluno1);
		lista.adicionaNoComeco(aluno2);
		lista.adicionaNoComeco(aluno3);
		lista.adicionaNoComeco(aluno4);
		
		System.out.println(lista.toString());
	}
	
}
