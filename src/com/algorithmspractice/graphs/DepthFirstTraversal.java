package com.algorithmspractice.graphs;

import java.util.LinkedList;

public class DepthFirstTraversal {

    public static void main(String args[]){
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        dfs(g, 0);
    }

    public static void dfs(Graph graph, int s){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.v];

        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + ", ");
            for (int w : graph.adjacencyList[u] ) {
                if(!visited[w]){
                    queue.push(w);
                    visited[w] = true;
                }
            }

        }
    }
}
