/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import java.util.Comparator;

/**
 * Priority Queue. This ADT after add a new Element, it will base on it's
 * priority to push it forward to the top.
 *
 * @author ADMIN
 * @param <T>
 */
public class LinkedPQueue {

    private Node front;
    private Node back;

    public LinkedPQueue() {
        this.front = null;
        this.back = null;
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }

    

    public boolean isEmpty() {
        return this.front == null;
    }

    

    public void clear() {
        this.front = null;
        this.back = null;
    }

    public void display() {
        Node current = this.front;
        while (current != null) {
            System.out.print(current.data.toString() + ", ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * First, add new Element to Queue, then compare it with each Elements in
     * Queue to locate it's correct location in the Queue.
     *
     * @param data
     * @param c
     */
    public void enQueue(Object data, Comparator<Object> c) {
        
        // Initiate New Node
        Node newNode = new Node(data);
        // Case Queue is empty
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {                // Case Queue is not empty

            this.back.next = newNode;
            newNode.previous = this.back;
            this.back = newNode;

            Node current = this.back;
            // Loop until found the correct position by going backward
            while (current != this.front && c.compare(current, current.previous) > 0) {
                current.data = current.previous.data;
                current = current.previous;
            }

            current.data = data;
        }
    }

    public Object deQueue() {
        // If queue is emtpy
        if (this.isEmpty()) {
            return null;
        }
        Object returnData = this.front.data;
        // If list have only 1 element then set back and front to null
        if (this.front == this.back) {
            this.back = null;
            this.front = null;
        } else {    // Else set the front as it's next Node
            this.front = this.front.next;
            this.front.previous = null;
        }
        return returnData;
    }
}
