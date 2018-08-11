package br.com.nemeth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        } catch(Exception ex) {
            System.out.println(ex);
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
    
    void carregarGrafo(String nomeArquivo) throws FileNotFoundException {
        File arquivo = new File(nomeArquivo);
        Scanner scanner = new Scanner(arquivo);
        
        Integer nVertices = scanner.nextInt();
        Integer nArestas = scanner.nextInt();                
        
        Integer isDir = scanner.nextInt();
        Integer isPond = scanner.nextInt();
        
        this.isDirecionado = isDir == 1;
        this.isPonderado = isPond == 1;
                
        for (int i = 0; i < nVertices; i++) {
            if(scanner.hasNext()) {
                String linha = scanner.next();
                this.inserirVertice();
            }
        }
        
        for (int i = 0; i < nArestas; i++) {
            Integer origem = scanner.nextInt();
            Integer destino = scanner.nextInt();
            if(isPond == 1) {
                Integer peso = scanner.nextInt();
                this.inserirAresta(origem, destino, peso);
            } else {
                this.inserirAresta(origem, destino);
            }
        }
        scanner.close();
    }
}
