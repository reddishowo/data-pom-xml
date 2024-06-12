package com.modul6.Tugas;
                                //Nizam Avif Anhari
import java.util.*;             //202210370311071

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;    //menyimpan adge
    private int numVertices;        //menyimpan node atau vertice

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);     //digunakan untuk mendapatkan arah dari edge
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];       //menandai node yang sudah di lewati
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(12);

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


        System.out.println("DFS:");
        graph.dfs(1); // Start the DFS from vertex 1

        System.out.println("\nBFS:");
        graph.bfs(1); // Start the BFS from vertex 1
    }
}