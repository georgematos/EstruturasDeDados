package conjunto.espalhamento;

public class ConjuntoEspalhamentoBuilder {

	private ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

	public ConjuntoEspalhamentoBuilder build(String ... palavras) {
		for (String palavra : palavras) {
			conjunto.adiciona(palavra);
		}
		return this;
	}

	public ConjuntoEspalhamento criar() {
		return conjunto;
	}

}
