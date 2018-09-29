package br.com.nemeth.grafo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Collections.reverseOrder;


public abstract class Grafo {
	protected Integer numVertices;
	protected Integer numArestas;

	protected boolean isDirecionado;
	protected boolean isPonderado;

	public List<String> vertices;

	public Grafo(boolean isDir, boolean isPond) {

		this.isDirecionado = isDir;
		this.isPonderado = isPond;
		preencherVertices(0);
	}

	public Grafo(String nomeArquivo) {
		numVertices = 0;
		numArestas = 0;
		vertices = new Vector<String>();
		try {
			this.carregarGrafo(nomeArquivo);
		} catch (Exception ex) {
			System.out.println("aqui");
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

	public abstract boolean preencherVertices(int nVertices);

	public abstract void imprimeGrafo();

	public abstract int retornaGrau(int indice);

	public List<Integer> coloracaoWP() {
		HashMap<Integer, Integer> grauVertices = new HashMap<Integer, Integer>();

		for (int i = 0; i < numVertices; i++) {
			grauVertices.put(i, retornaGrau(i));

		}
		List<Map.Entry<Integer, Integer>> sorted_map =
                grauVertices.entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());
		
		System.out.println();
		
		grauVertices.entrySet().stream()
		   .sorted(Map.Entry.comparingByValue())
		   .forEach(System.out::println);
		
		int corAtual = 0;
		List<Integer> corVertice = new Vector<Integer>();
		
		for (int i = 0; i < grauVertices.size(); i++) {
			corVertice.add(-1);
		}
		int contador = grauVertices.size();
		while (contador > 0) {
			for (int j = 0; j < corVertice.size(); j++) {
				if (corVertice.get(grauVertices.get(j)) == -1) {
					List<Integer> vizinhos = retornarVizinhos(grauVertices.get(j));
					boolean pode = true;
					
					for (int k =0; k < vizinhos.size(); k++) {
						if(corVertice.get(vizinhos.get(k)) == corAtual) {
							pode = false;
							break;
						}
					}
					if (pode) {
						corVertice.set(grauVertices.get(j), corAtual);
					}
				}
			
			}
			corAtual++;
		}
		
		
		System.out.println("Tamnho da resposta: "+corVertice.size());
		
		return corVertice;
	}

	public boolean comparar(Map<Integer, Integer> primeiro, Map<Integer, Integer> segundo) {
		return primeiro.get(2) > segundo.get(2);
	}

	void carregarGrafo(String nomeArquivo) throws IOException {
		File arquivo = new File(nomeArquivo);
		Scanner scanner = new Scanner(arquivo);

		Integer nVertices = scanner.nextInt();
		Integer nArestas = scanner.nextInt();

		Integer isDir = scanner.nextInt();
		Integer isPond = scanner.nextInt();

		this.isDirecionado = isDir == 1;
		this.isPonderado = isPond == 1;
		preencherVertices(nVertices);

		for (int i = 0; i < nVertices; i++) {
			if (scanner.hasNext()) {
				String linha = scanner.next();
				this.inserirVertice(linha);
			}
		}
		System.out.println("nVertices:" + nVertices);
		System.out.println("nArestas: " + nArestas);
		for (int i = 0; i < nArestas; i++) {
			Integer origem = scanner.nextInt();
			Integer destino = scanner.nextInt();
			if (isPond == 1) {
				Integer peso = scanner.nextInt();
				this.inserirAresta(origem, destino, peso);
			} else {
				this.inserirAresta(origem, destino);
			}
		}
		scanner.close();
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

	public List<String> getVertices() {
		return vertices;
	}

	public void setVertices(List<String> vertices) {
		this.vertices = vertices;
	}

}
