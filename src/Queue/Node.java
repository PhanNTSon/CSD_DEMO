/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 * Class Node represent as a Node in Queue or Stack that could hold any type of
 * data, therefore need to use Generic T.Because each Node can compare to each
 * other, therefore T need to implement interface Comparator to have method
 * compareTo() inside it for comparing. Therefore: T extends Comparable Class
 * Node also need to implement Comparable to compare.
 *
 * @author ADMIN
 * @param <T>
 */
public class Node {

    Object data;
    Node next;
    Node previous;

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

}
