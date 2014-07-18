package conjunto.espalhamento;

public class ConjuntoEspalhamentoBuilder {

	private ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

	public ConjuntoEspalhamentoBuilder build(Object ... objects) {
		for (Object object : objects) {
			conjunto.adiciona(object);
		}
		return this;
	}

	public ConjuntoEspalhamento criar() {
		return conjunto;
	}

}
