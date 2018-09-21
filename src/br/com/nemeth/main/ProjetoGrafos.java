package br.com.nemeth.main;

import java.io.File;

import br.com.nemeth.algoritmos.Dijkstra;
import br.com.nemeth.grafo.Grafo;
import br.com.nemeth.impl.GrafoLista;
import br.com.nemeth.impl.GrafoMatriz;

public class ProjetoGrafos {

	public static void main(String[] args) {
		Grafo grafo = null;
		try {
			grafo = new GrafoMatriz(new File("Dijkstra2.txt").getAbsolutePath());
		} catch (NullPointerException e) {
			System.out.println("Null");
		}
		// Grafo grafo = new GrafoMatriz(true, true);

//		 Grafo grafo = new GrafoLista(false, false);

//		 grafo.inserirVertice("A");
//		 grafo.inserirVertice("B");
//		 grafo.inserirVertice("C");
//		 grafo.inserirVertice("D");
//		
//		 grafo.inserirAresta(0, 1);
//		 grafo.inserirAresta(3, 2, 5);
//		 grafo.inserirAresta(2, 1);
//		
//		 grafo.existeAresta(0, 1);
		System.out.println("Numero vertices:" +grafo.vertices.size());
		grafo.imprimeGrafo();

		Dijkstra.execute(grafo, 0);
	}

}
