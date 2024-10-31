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
    private int size, cap;

    public LinkedPQueue(int cap) {
        this.front = null;
        this.back = null;
        this.cap = cap;
        this.size = 0;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.cap;
    }

    public void clear() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void display() {
        Node current = this.front;
        while (current != null) {
            System.out.print(current.getData().toString() + ", ");
            current = current.getNext();
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
        if (this.isFull()) {
            throw new IndexOutOfBoundsException();
        }
        // Initiate New Node
        Node newNode = new Node(data);
        // Case Queue is empty
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {                // Case Queue is not empty

            this.back.setNext(newNode);
            newNode.setPrevious(this.back);
            this.back = newNode;

            Node current = this.back;
            // Loop until found the correct position by going backward
            while (current != this.front && c.compare(current, current.getPrevious()) > 0) {
                current.setData(current.getPrevious().getData());
                current = current.getPrevious();
            }

            current.setData(data);
        }
        this.size++;
    }

    public Object deQueue() {
        // If queue is emtpy
        if (this.isEmpty()) {
            throw new ArrayStoreException();
        }
        Object returnData = this.front.getData();
        // If list have only 1 element then set back and front to null
        if (this.size == 1) {
            this.back = null;
            this.front = null;
        } else {    // Else set the front as it's next Node
            this.front = this.front.getNext();
            this.front.setPrevious(null);
        }
        this.size--;
        return returnData;
    }
}
