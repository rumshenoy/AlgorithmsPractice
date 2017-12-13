package com.algorithmspractice.graphs;

import java.util.LinkedList;

class Graph{
    public int v;
    public LinkedList<Integer>[] adjacencyList;

    Graph(int v){
        this.v = v;
        adjacencyList = new LinkedList[v];
        for(int i=0; i < v; i++){
            adjacencyList[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w){
        adjacencyList[v].add(w);
    }

}
