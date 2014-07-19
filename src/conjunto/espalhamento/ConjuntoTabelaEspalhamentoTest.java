package conjunto.espalhamento;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ConjuntoTabelaEspalhamentoTest {

	private ConjuntoEspalhamento conjuntoEsp;
	private ConjuntoEspalhamentoBuilder builder;

	@Before
	public void inicia() {
		conjuntoEsp = new ConjuntoEspalhamento();
		builder = new ConjuntoEspalhamentoBuilder();
	}

	@Test
	public void deveVerificarSePalavraExiste() {
		conjuntoEsp = builder.build(
				"Java", "C#", "C++",
				"ASP", "Ruby", "Python",
				"Schala", "Swift", "Perl",
				"JavaScript")
				.criar();

		assertTrue(conjuntoEsp.contem("Java"));
	}

	@Test
	public void deveAdicionarUmaNovaPalavra() {
		conjuntoEsp = builder.build(
				"Java", "C#", "C++",
				"ASP", "Ruby", "Python",
				"Schala", "Swift", "Perl",
				"JavaScript")
				.criar();

		conjuntoEsp.adiciona("Groovy");

		assertTrue(conjuntoEsp.contem("Groovy"));
	}

	@Test
	public void deveRemoverUmaNovaPalavra() {
		conjuntoEsp = builder.build(
				"Java", "C#", "C++",
				"ASP", "Ruby", "Python",
				"Schala", "Swift", "Perl",
				"JavaScript")
				.criar();

		conjuntoEsp.remove("Ruby");

		assertTrue(!conjuntoEsp.contem("Ruby"));
	}

	@Test
	public void deveImprimirATabelaNoConsole() {
		conjuntoEsp = builder.build(
				"Java", "C#", "C++",
				"ASP", "Ruby", "Python",
				"Schala", "Swift", "Perl",
				"JavaScript")
				.criar();

		conjuntoEsp.imprimeTabela();
	}

	@Test
	public void deveCalcularDesempenhoDaTabela() {
		long inicio = System.currentTimeMillis();

		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

		for (int i = 0; i < 500000; i++) {
			conjunto.adiciona("palavra" + i);
		}

		for (int i = 0; i < 500000; i++) {
			conjunto.contem("palavra" + i);
		}

		long fim = System.currentTimeMillis();

		System.out.println("Tempo: " +  (fim - inicio) / 1000.0);

//		assertTrue(((fim - inicio) / 1000.0) <= 0.500); // requisito funcional
	}

}
