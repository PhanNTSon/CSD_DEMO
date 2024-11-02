package DoubleLinkedList;

/**
 *
 * @author ADMIN
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
