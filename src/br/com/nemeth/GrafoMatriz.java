package br.com.nemeth;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatriz extends Grafo {
    
    public List<List<Integer> > arestas = new ArrayList<List<Integer>>();
    
    public GrafoMatriz(boolean isDir, boolean isPond) {
        super(isPond, isDir);
    }
    
    public GrafoMatriz(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    boolean inserirVertice() {
        //insere um vertice com o nome igual ao indice
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean inserirVertice(String label) {
        //insere um vertice com o nome passado por parametro
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean removerVertice(String label) {
        //remove um vertice com o nome passado por parametro
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean removerVertice(Integer indice) {
        //remove um vertice de acordo com o indice passado por parametro
        //lembrar de apagar as arestas que saem e chegam nele
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean inserirAresta(Integer origem, Integer destino) {
        //insere uma aresta entre dois vertices passados por parametro
        //caso o grafo for direcionado, adiciona um arco
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean inserirAresta(Integer origem, Integer destino, Integer peso) {
        //insere uma aresta entre dois vertices passados por parametro
        //caso o grafo for direcionado, adiciona um arco
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean removerAresta(Integer origem, Integer destino) {
        //apaga uma aresta entre os dois vertices passados por parametro
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    Integer indiceVertice(String label) {
        //retorna o indice de um vertice passando seu nome
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    String labelVertice(Integer indice) {
        //retorna o nome do vertice pelo indice passado por parametro
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    boolean existeAresta(Integer origem, Integer destino) {
        //retorna verdadeiro caso exista uma aresta entre os vertices passados por parametro
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    List<Integer> retornarVizinhos(Integer vertice) {
        //retorna os indices dos vertices vizinhos ao vertice passado por parametro
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    void imprimeGrafo() {
        //exibe a estrutura do grafo no console
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
