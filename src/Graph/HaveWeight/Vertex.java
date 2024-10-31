/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph.HaveWeight;

import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class Vertex  {

    private String label;
    private HashMap<Vertex, Integer> adjList;

    public Vertex(String lable) {
        this.label = lable;
        this.adjList = new HashMap<>();
    }

    public String getLabel() {
        return label;
    }

    public HashMap<Vertex, Integer> getAdjList() {
        return adjList;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
}
