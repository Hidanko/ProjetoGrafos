package br.com.nemeth.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import br.com.nemeth.grafo.Grafo;

public class GrafoMatriz extends Grafo {

	public List<List<Integer>> arestas;

	public GrafoMatriz(boolean isDir, boolean isPond) {
		super(isDir, isPond);

	}

	public GrafoMatriz(String nomeArquivo) {
		super(nomeArquivo);

	}

	@Override
	public boolean inserirVertice() {
		// insere um vertice com o nome igual ao indice
		List<Integer> lista = new Vector<Integer>();
		arestas.add(lista);
		return true;

	}

	@Override
	public boolean inserirVertice(String label) {
		// insere um vertice com o nome passado por parametro
		vertices.add(label);

		numVertices++;

		List<Integer> lista = new Vector<Integer>();

		for (int i = 0; i < numVertices; i++) {
			lista.add(i, 0);
		}

		for (int i = 0; i < numVertices - 1; i++) {
			arestas.get(i).add(0);
		}
		if (arestas == null) {
			arestas = new ArrayList<List<Integer>>();
		}
		arestas.add(lista);
		return true;

	}

	@Override
	public boolean removerVertice(String label) {
		// remove um vertice com o nome passado por parametro
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean removerVertice(Integer indice) {
		// remove um vertice de acordo com o indice passado por parametro
		// lembrar de apagar as arestas que saem e chegam nele
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean inserirAresta(Integer origem, Integer destino) {
		return inserirAresta(origem, destino, 1);
	}

	@Override
	public boolean inserirAresta(Integer origem, Integer destino, Integer peso) {
		// insere uma aresta entre dois vertices passados por parametro
		// caso o grafo for direcionado, adiciona um arco
		arestas.get(origem).set(destino, peso);

		if (!isDirecionado) {
			arestas.get(destino).set(origem, peso);
		}
		return true;

	}

	@Override
	public boolean removerAresta(Integer origem, Integer destino) {
		// apaga uma aresta entre os dois vertices passados por parametro
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Integer indiceVertice(String label) {
		// retorna o indice de um vertice passando seu nome
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String labelVertice(Integer indice) {

		return vertices.get(indice);
	}

	@Override
	public boolean existeAresta(Integer origem, Integer destino) {
		// retorna verdadeiro caso exista uma aresta entre os vertices passados por
		// parametro

		return (arestas.get(origem).get(destino) != 0);

	}

	@Override
	public List<Integer> retornarVizinhos(Integer vertice) {
		List<Integer> vizinhos = new Vector<Integer>();

		for (int i = 0; i < numVertices; i++) {
			if (existeAresta(vertice, i)) {
				vizinhos.add(i);
			}
		}

		return vizinhos;
	}

	@Override
	public void imprimeGrafo() {
		// exibe a estrutura do grafo no console
		System.out.print("\n*\t");
		for (int i = 0; i < numVertices; i++) {
			System.out.print(vertices.get(i) + "\t");
		}
		System.out.println("");
		for (int i = 0; i < numVertices; i++) {
			System.out.print(vertices.get(i) + "\t");
			for (int j = 0; j < numVertices; j++) {

				System.out.print(arestas.get(i).get(j) + "\t");
			}
			System.out.println("");
		}

	}

	@Override
	public boolean preencherVertices(int nVertices) {
		arestas = new ArrayList<List<Integer>>();

		for (int i = 0; i < nVertices; i++) {
			List<Integer> lista = new Vector<Integer>();
			for (int j = 0; j < nVertices; j++) {
				lista.add(0);
			}
			arestas.add(lista);
		}

		return false;
	}

	public List<List<Integer>> getArestas() {
		return arestas;
	}

	public void setArestas(List<List<Integer>> arestas) {
		this.arestas = arestas;
	}

	@Override
	public int retornaGrau(int indice) {
		int num = 0;
		for (int i = 0; i < numVertices; i++) {
			if (existeAresta(indice, i)) {
				num++;
			}
		}
		return num;
	}

}
