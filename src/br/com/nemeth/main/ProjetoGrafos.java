package br.com.nemeth.main;

import br.com.nemeth.Grafo;
import br.com.nemeth.GrafoLista;
import br.com.nemeth.GrafoMatriz;

public class ProjetoGrafos {

	public static void main(String[] args) {
		// Grafo grafo = new GrafoMatriz("teste.txt");

		Grafo grafo = new GrafoMatriz(true, true);

//		 Grafo grafo = new GrafoLista(false, false);

		grafo.inserirVertice("A");
		grafo.inserirVertice("B");
		grafo.inserirVertice("C");
		grafo.inserirVertice("D");

		grafo.inserirAresta(0, 1);
		grafo.inserirAresta(3, 2, 5);
		grafo.inserirAresta(2, 1);
		
		grafo.existeAresta(1, 1);
		
		grafo.imprimeGrafo();

	}

}
