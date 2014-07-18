package conjunto.espalhamento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {

	private List<List<String>> tabela = new ArrayList<>();
	private int tamanho;

	public ConjuntoEspalhamento() {
		for (int i = 0; i < 26; i++) {
			LinkedList<String> lista = new LinkedList<>();
			tabela.add(lista);
		}
	}

	public int funcaoDeEspalhamento(String palavra) {
		int indice = palavra.toLowerCase().charAt(0) % 26; // o resto da divisão de qualquer numero sempre será um numero entre 0 e ele mesmo
		return indice;
	}

	public void adiciona(String palavra) {
		if(!contem(palavra)) {
			int indice = funcaoDeEspalhamento(palavra);
			List<String> lista = tabela.get(indice); // lista é uma referencia para a LinkedList que se encontra no indice da tabela
			lista.add(palavra);
			tamanho++;
		}
	}

	public void remove(String palavra) {
		if (contem(palavra)) {
			int indice = funcaoDeEspalhamento(palavra);
			List<String> lista = tabela.get(indice);
			lista.remove(palavra);
			tamanho--;
		}
	}

	public boolean contem(String palavra) {
		int indice = funcaoDeEspalhamento(palavra);
		List<String> lista = tabela.get(indice);
		return lista.contains(palavra);
	}

	public List<String> pegaTodas() {
		List<String> palavras = new ArrayList<>();
		for (int i = 0; i < tabela.size(); i++) {
			palavras.addAll(tabela.get(i));
		}
		return palavras;
	}

	public int tamanho() {
		return tamanho;
	}

}
