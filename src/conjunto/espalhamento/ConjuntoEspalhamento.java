package conjunto.espalhamento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {

	private List<List<Object>> tabela = new ArrayList<>();
	private int tamanho;

	public ConjuntoEspalhamento() {
		for (int i = 0; i < 26; i++) {
			LinkedList<Object> lista = new LinkedList<>();
			tabela.add(lista);
		}
	}

	public int calculaIndiceDaTabela(Object objeto) {
		// int indice = object.toLowerCase().charAt(0) % 26; // o resto da divisão de qualquer numero sempre será um numero entre 0 e ele mesmo
		// return indice;

		int codigoDeEspalhamento = objeto.hashCode();
		codigoDeEspalhamento = Math.abs(codigoDeEspalhamento); // Evita numeros negativos
		return codigoDeEspalhamento % tabela.size();

	}

	public void adiciona(Object object) {
		if (!contem(object)) {

			verificaCarga();

			int indice = calculaIndiceDaTabela(object);

			/** lista é uma referencia para a LinkedList que se encontra no indice da tabela */
			List<Object> lista = tabela.get(indice);

			lista.add(object);
			tamanho++;
		}
	}

	public void remove(Object object) {
		if (contem(object)) {
			int indice = calculaIndiceDaTabela(object);
			List<Object> lista = tabela.get(indice);
			lista.remove(object);
			tamanho--;

			verificaCarga();
		}
	}

	public boolean contem(Object object) {
		int indice = calculaIndiceDaTabela(object);
		List<Object> lista = tabela.get(indice);
		return lista.contains(object);
	}

	public List<Object> pegaTodas() {
		List<Object> objects = new ArrayList<>();
		for (int i = 0; i < tabela.size(); i++) {
			objects.addAll(tabela.get(i));
		}
		return objects;
	}

	public int tamanho() {
		return tamanho;
	}

	public void imprimeTabela(){
		for (List<Object> lista : this.tabela) {
			System.out.print("[");
		    for (int i = 0; i < lista.size(); i++) {
		    	System.out.print(lista.get(i) + ", ");
		    }
		    System.out.println("]");
		}
	}

	private void redimensionaTabela(int novaCapacidade) {
		List<Object> objects = pegaTodas();
		tabela.clear();

		for (int i = 0; i < novaCapacidade; i++) {
			tabela.add(new LinkedList<Object>());
		}

		for (Object object : objects) {
			adiciona(object);
		}
	}

	private void verificaCarga() {
		int capacidade = tabela.size();
		double carga = (double) tamanho / capacidade;

		if (carga > 0.75) {
			redimensionaTabela(capacidade * 2);
		} else if (carga < 0.25) {
			redimensionaTabela(Math.max(capacidade / 2, 10));
		}
	}

}
