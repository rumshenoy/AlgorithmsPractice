package com.algorithmspractice.graphs;

import java.util.LinkedList;

public class BreadthFirstTraversal {
    public static void main(String args[]){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        bfs(g, 2);
    }

    public static void bfs(Graph graph, int s){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.v];

        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + ", ");
            for (int w : graph.adjacencyList[u] ) {
                if(!visited[w]){
                    visited[w] = true;
                    queue.push(w);
                }
            }

        }
    }
}

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
