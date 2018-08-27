package br.com.nemeth;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GrafoLista extends Grafo {
	List<List<Aresta>> arestas;

	public GrafoLista(boolean isDir, boolean isPond) {

		super(isDir, isPond);
		vertices = new Vector<String>();
		numVertices=0;
		numArestas=0;
	}

	public GrafoLista(String nomeArquivo) {
		super(nomeArquivo);

	}

	@Override
	public boolean inserirVertice() {
		// insere um vertice com o nome igual ao indice

		vertices.add("");
		numVertices++;
		return true;
	}

	@Override
	public boolean inserirVertice(String label) {

		// insere um vertice com o nome passado por parametro
		vertices.add(label);
		arestas.add(new Vector<Aresta>());
		numVertices++;
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

		Aresta novaAresta = new Aresta(destino, peso);


		arestas.get(origem).add(novaAresta);

		if (isDirecionado == false) {
			novaAresta.destino = origem;
			arestas.get(destino).add(novaAresta);
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

		for (int i = 0; i < arestas.get(origem).size(); i++) {
			if (arestas.get(origem).get(i).destino == destino) {
				System.out.println("existe");
				return true;

			}
		}
		System.out.println("n�o existe");
		return false;
	}

	@Override
	public List<Integer> retornarVizinhos(Integer vertice) {
		List<Integer> vizinhos = new Vector<Integer>();

		for (int i = 0; i < arestas.get(vertice).size(); i++) {
			vizinhos.add(arestas.get(vertice).get(i).destino);
		}

		return vizinhos;
	}

	@Override
	public void imprimeGrafo() {
		// exibe a estrutura do grafo no console
		System.out.println("NUmero vertices - imprimeGrafo: "+numVertices);
		for (int i = 0; i < numArestas; i++) {
			System.out.print(vertices.get(i) + " ->\t");

			for (int j = 0; j < arestas.get(i).size()-1; j++) {
				System.out.print(labelVertice(arestas.get(i).get(j).destino) + ", ");
			}
			System.out.println("");
		}
	}

	@Override
	public boolean preencherVertices(int nVertices) {
		arestas  = new ArrayList<List<Aresta>>();
		
		for (int i = 0; i <nVertices; i++) {
			arestas.add(new Vector<Aresta>());
		}
		return false;
	}
}
