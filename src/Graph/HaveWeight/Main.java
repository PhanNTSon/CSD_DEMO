/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph.HaveWeight;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("B", "E", 1);
        graph.addEdge("C", "E", 2);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 5);
        graph.addEdge("D", "F", 4);
        graph.addEdge("E", "F", 3);

        //graph.display();
//        graph.Dijkstra("A", "F");
//        graph.DijkstraRef("A", "F");
        graph.MST_Prims("A");
        System.out.println("=======================");
        Graph test = graph.MST_Kruskal();
        test.display();
    }
}
