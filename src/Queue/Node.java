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
public class Node  {

    private Object data;
    private Node next;
    private Node previous;

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    
}
