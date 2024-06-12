package com.modul6.Codelab;

import java.util.*;

public class BFSTraversal {
    private int node;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;
    
    BFSTraversal(int v){
        node = v;
        adj = new LinkedList[node];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<Integer>();
    }

    void insertEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v); // Because the graph is undirected
    }
    
    void BFS(int n){
        boolean nodes[] = new boolean[node];
        int a;
        nodes[n] = true;
        que.add(n);
        
        while(que.size() != 0){
            n = que.poll();
            System.out.print(n + " ");
            for (int i = 0; i < adj[n].size(); i++){
                a = adj[n].get(i);
                if(!nodes[a]){
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);

        // Insert edges based on the given graph
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 5);
        graph.insertEdge(0, 4);
        graph.insertEdge(1, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(4, 5);

        System.out.println("Breadth First Traversal for the graph starting from vertex 3 is:");
        graph.BFS(3);
    }
}
