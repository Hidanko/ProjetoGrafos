package br.com.nemeth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public abstract class Grafo {
	Integer numVertices;
	Integer numArestas;

	boolean isDirecionado;
	boolean isPonderado;

	public List<String> vertices;

	public Grafo(boolean isDir, boolean isPond) {

		this.isDirecionado = isDir;
		this.isPonderado = isPond;
	}

	public Grafo(String nomeArquivo) {
		vertices = new ArrayList<String>();
		try {
			this.carregarGrafo(nomeArquivo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public abstract boolean inserirVertice();

	public abstract boolean inserirVertice(String label);

	public abstract boolean removerVertice(String label);

	public abstract boolean removerVertice(Integer indice);

	public abstract boolean inserirAresta(Integer origem, Integer destino);

	public abstract boolean inserirAresta(Integer origem, Integer destino, Integer peso);

	public abstract boolean removerAresta(Integer origem, Integer destino);

	public abstract Integer indiceVertice(String label);

	public abstract String labelVertice(Integer indice);

	public abstract boolean existeAresta(Integer origem, Integer destino);

	public abstract List<Integer> retornarVizinhos(Integer vertice);

	public abstract void imprimeGrafo();

	void carregarGrafo(String nomeArquivo) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

		String[] inteiros = br.readLine().split(" ");
		
		Integer nVertices = new Integer(inteiros[0]);
		Integer nArestas = new Integer(inteiros[1]);

		Integer isDir = new Integer(inteiros[2]);
		Integer isPond = new Integer(inteiros[3]);

		this.isDirecionado = isDir == 1;
		this.isPonderado = isPond == 1;

		
		String linha;
		for (int i = 0; i < nVertices; i++) {
				linha = br.readLine();
				this.inserirVertice(linha);
		}

		for (int i = 0; i < nArestas; i++) {
			String[] inteiros2 = br.readLine().split(" ");
			Integer origem = new Integer(inteiros[0]);
			Integer destino = new Integer(inteiros[1]);
			if (isPond == 1) {
				Integer peso = new Integer(br.readLine());
				this.inserirAresta(origem, destino, peso);
			} else {
				this.inserirAresta(origem, destino);
			}
		}
		br.close();
	}

	List<Integer> buscaProfundidade(int verticeInicial, int verticeFinal) {
		List<Integer> saida = new Vector<Integer>();
		List<Integer> pilha = new Stack<Integer>();

		List<Boolean> controle = new Vector<Boolean>();

		for (int i = 0; i < vertices.size(); i++) {
			controle.add(false);
		}

		saida.add(verticeInicial);
		pilha.add(verticeInicial);
		controle.set(verticeInicial, true);

		while (pilha.size() > 0) {
			List<Integer> vizinhos = retornarVizinhos(pilha.get(pilha.size()));
			boolean achou = false;
			for (int i = 0; i < vizinhos.size(); i++) {
				if (!controle.get(vizinhos.get(i))) {
					pilha.add(vizinhos.get(i));
					saida.add(vizinhos.get(i));
					controle.set(vizinhos.get(i), true);
					achou = true;
					if (vizinhos.get(i) == verticeFinal) {
						return saida;
					}
					break;
				}
			}
			if (!achou)
				pilha.remove(pilha.size() - 1);

		}

		return saida;
	}

	List<Integer> buscaLargura(int verticeInicial) {
		List<Integer> saida = new Vector<Integer>();
		List<Integer> fila = new LinkedList<Integer>();

		List<Boolean> controle = new Vector<Boolean>();

		for (int i = 0; i < vertices.size(); i++) {
			controle.add(false);
		}

		saida.add(verticeInicial);
		fila.add(verticeInicial);
		controle.set(verticeInicial, true);

		while (fila.size() > 0) {
			List<Integer> vizinhos = retornarVizinhos(fila.get(0));
			for (int i = 0; i < vizinhos.size(); i++) {
				if (!controle.get(vizinhos.get(i))) {
					fila.add(vizinhos.get(i));
					saida.add(vizinhos.get(i));
					controle.set(vizinhos.get(i), true);
				}
			}
			fila.remove(fila.size() - 1);

		}

		return saida;
	}
}
