/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        AVL<String> tree = new AVL<>();
        for (int i = 0; i < 14; i++) {
            tree.insertNode(Integer.toString(i));
        }
        tree.BFS();
    }
}
