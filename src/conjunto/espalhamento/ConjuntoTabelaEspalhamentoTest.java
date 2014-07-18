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

}
