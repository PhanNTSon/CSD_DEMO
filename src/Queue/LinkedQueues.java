/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class LinkedQueues {

    private Node front;
    private Node back;
    private int size, cap;

    public LinkedQueues(int cap) {
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
    
    public boolean isFull(){
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
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void enQueue(Object data) {
        if (this.isFull()){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.setNext(newNode);
            this.back = newNode;
        }
        this.size++;
    }

    public Object deQueue() {
        if (this.isEmpty()) {
            throw new ArrayStoreException();
        }
        Object returnData = this.front.getData();
        if (this.size == 1) {
            this.back = null;
            this.front = null;
        } else {
            this.front = this.front.getNext();
        }
        this.size--;
        return returnData;
    }

}
