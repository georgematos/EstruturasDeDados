package listas.array;

import java.util.ArrayList;

public class EstudoArrayList {

	public static void main(String[] args) {
		
		ArrayList<Aluno> lista = new ArrayList<>();
		
		Aluno aluno1 = new Aluno("George");
		Aluno aluno2 = new Aluno("Livia");
		Aluno aluno3 = new Aluno("Vanda");
		
		lista.add(aluno1);
		lista.add(aluno2);
		lista.add(aluno3);
		
		lista.add(0, lista.get(1));
		
		System.out.println(lista.toString());
		
		System.out.println(lista.get(0).equals(lista.get(2)));
		
	}
	
}
