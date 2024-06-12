package com.modul6.Tugas;

import java.util.*;

class Graph_OLD {
    private int numVertices;
    private LinkedList<Integer> adjLists[];

    // Constructor
    Graph_OLD(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList();
    }

    // Add edge
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // DFS algorithm
    void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
            }

            Iterator<Integer> ite = adjLists[vertex].listIterator();
            while (ite.hasNext()) {
                int adj = ite.next();
                if (!visited[adj]) {
                    stack.push(adj);
                }
            }
        }
    }

    // BFS algorithm
    void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            Iterator<Integer> ite = adjLists[vertex].listIterator();
            while (ite.hasNext()) {
                int adj = ite.next();
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph_OLD graph = new Graph_OLD(12);

        // Add edges
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 10);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(5, 9);
        graph.addEdge(6, 1);
        graph.addEdge(7, 8);
        graph.addEdge(7, 11);
        graph.addEdge(8, 4);
        graph.addEdge(11, 1);

        System.out.println("DFS starting from vertex 1:");
        graph.DFS(1);

        System.out.println("\nBFS starting from vertex 1:");
        graph.BFS(1);
    }
}
