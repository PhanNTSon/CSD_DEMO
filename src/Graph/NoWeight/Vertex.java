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
public class Vertex {
    private String label;
    private Set<Vertex> adjList;

    public Vertex(String lable) {
        this.label = lable;
        this.adjList = new HashSet<>();
    }

    public String getLabel() {
        return label;
    }

    public Set<Vertex> getAdjList() {
        return adjList;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
