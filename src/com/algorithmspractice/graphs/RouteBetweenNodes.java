package com.algorithmspractice.graphs;
//4.1 CTCI Given a directed graph, design an algorithm to find out whether there is a route between the two nodes

import java.util.LinkedList;

enum State{Unvisited, Visited, Visiting}

class UndirectedGraph{
    public Node[] nodes;

    public UndirectedGraph(int number) {
        nodes = new Node[5];
    }

    public Node[] getNodes() {
        return nodes;
    }
}
class Node{
    public String name;
    public Node[] children;
    State state;
    private Node[] adjacent;

    public Node(String a) {
        this.name = a;
    }

    public Node[] getAdjacent() {
        return children;
    }
}
public class RouteBetweenNodes {
    public static void main(String args[]){
        UndirectedGraph g = new UndirectedGraph(6);

        Node a = g.nodes[0] = new Node("a");
        Node b = g.nodes[1] = new Node("b");
        Node c = g.nodes[2] = new Node("c");
        Node d = g.nodes[3] = new Node("d");
        Node e = g.nodes[4] = new Node("e");
        Node f = g.nodes[4] = new Node("f");



        a.children = new Node[]{b, c, e};
        b.children = new Node[]{a, c};
        c.children = new Node[]{a, b, e};
        d.children = new Node[]{e};
        e.children = new Node[]{a, c, d};
        f.children = new Node[]{};

        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        boolean result = routeBetweenNodes.search(g, a, f);
        System.out.println(result);
    }

    public boolean search(UndirectedGraph g, Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        queue.add(start);

        Node u;
        while (!queue.isEmpty()) {
            u = queue.pop();
            for (Node v : u.getAdjacent()) {
                if(v.state == State.Unvisited){
                    if(v.name == end.name){
                        return true;
                    }else{
                        v.state = State.Visiting;
                        queue.add(v);
                    }
                }
            }

            u.state = State.Visited;
        }

        return false;
    }
}
