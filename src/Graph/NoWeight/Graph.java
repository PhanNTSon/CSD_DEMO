/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph.NoWeight;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Graph {

    private Set<Vertex> vertices;

    public Graph() {
        this.vertices = new HashSet<>();
    }

    /**
     * Find a specific Vertex in set Vertices.
     *
     * @param lable
     * @return
     */
    public Vertex getVertex(String lable) {
        // First turn Set into Stream
        return this.vertices.stream()
                // Then find all vertex that have same lable
                .filter(vertex -> vertex.getLabel().equalsIgnoreCase(lable))
                // Take out the first Element 
                .findFirst()
                // If there is no Element sastified filter, return null
                .orElse(null);
    }

    /**
     * Add new vertex to Graph.
     *
     * @param lable
     */
    public void addVertex(String lable) {
        vertices.add(new Vertex(lable));
    }

    /**
     * Add edge between 2 vertices in Graph.
     *
     * @param vertex1
     * @param vertex2
     */
    public void addEdge(String vertex1, String vertex2) {
        // Initiate Vertex v1 and find it in Graph
        Vertex v1 = this.getVertex(vertex1);
        // Initiate Vertex v2 and find it in Graph
        Vertex v2 = this.getVertex(vertex2);
        // If v1 is null means no Vertex have label v1 in Graph
        if (v1 == null) {
            // Add new Vertex v1 to Graph
            this.addVertex(vertex1);
            // Set v1 as that new Vertex
            v1 = this.getVertex(vertex1);
        }
        // If v2 is null means no Vertex have label v2 in Graph
        if (v2 == null) {
            // Add new Vertex v2 to Graph
            this.addVertex(vertex2);
            // Set v2 as that new Vertex
            v2 = this.getVertex(vertex2);
        }

        // Connect 2 vertices by adding to their adjList
        // Add v2 to v1's adjList
        v1.getAdjList().add(v2);
        // Add v1 to v2's adjList
        v2.getAdjList().add(v1);
    }

    /**
     * Display Graph by showing all Vertices in Graph and its connection.
     */
    public void display() {
        // Transform set vertices into Stream
        this.vertices.stream()
                // For each element in Stream
                .forEach(vertex -> {
                    // Display into a format: vertex -> {e1, e2, ...}
                    System.out.print(vertex.getLabel());
                    System.out.print("-> {");
                    vertex.getAdjList().forEach(adjV -> System.out.print(adjV.getLabel() + ","));
                    System.out.println("}");
                });
    }
}
