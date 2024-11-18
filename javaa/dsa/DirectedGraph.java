package javaa.dsa;

import java.util.*;

public class DirectedGraph {
    public int count;
    private Map<Integer, List<Integer>> adjList;

    public DirectedGraph() {
        this.count = 0;
        this.adjList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
        count++;
    }

    // Add an edge to the graph (directed)
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
    }

    // Remove an edge from the graph
    public void removeEdge(int source, int destination) {
        List<Integer> edges = adjList.get(source);
        if (edges != null) {
            edges.remove(Integer.valueOf(destination));
        }
    }

    // Remove a vertex from the graph
    public void removeVertex(int vertex) {
        // Remove vertex from all adjacency lists
        adjList.values().forEach(e -> e.remove(Integer.valueOf(vertex)));
        adjList.remove(vertex);
    }

    // Get neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    // Check if the graph contains a vertex
    public boolean containsVertex(int vertex) {
        return adjList.containsKey(vertex);
    }

    // Check if an edge exists between two vertices
    public boolean containsEdge(int source, int destination) {
        return adjList.containsKey(source) && adjList.get(source).contains(destination);
    }

    // Print the graph
    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        // Print the graph
        graph.printGraph();

        // Check neighbors
        System.out.println("Neighbors of vertex 1: " + graph.getNeighbors(1));
        System.out.println("Contains edge 1 -> 2: " + graph.containsEdge(1, 2));
        System.out.println("Contains edge 4 -> 1: " + graph.containsEdge(4, 1));

        // Remove an edge
        graph.removeEdge(1, 2);
        System.out.println("\nGraph after removing edge 1 -> 2:");
        graph.printGraph();

        // Remove a vertex
        graph.removeVertex(3);
        System.out.println("\nGraph after removing vertex 3:");
        graph.printGraph();
    }

}
