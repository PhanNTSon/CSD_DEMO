/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 * Deque is a type of Queue that can do these functions: Add first, Add Last,
 * Remove First and Remove Last.
 *
 * @author ADMIN
 * @param <T>
 */
public class LinkedDeque<T extends Comparable<T>> {
    private Node<T> front;
    private Node<T> back;
    private int size, cap;

    public LinkedDeque(int cap) {
        this.front = null;
        this.back = null;
        this.cap = cap;
        this.size = 0;
    }

    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getBack() {
        return back;
    }

    public void setBack(Node<T> back) {
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

    public void enQueueFront(T data) {
        if (this.isFull()){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node(data);
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            newNode.setNext(this.front);
            this.front.setPrevious(newNode);
            this.front = newNode;
        }
        this.size++;
    }

    public T deQueueFront() {
        if (this.isEmpty()) {
            throw new ArrayStoreException();
        }
        T returnData = this.front.getData();
        if (this.size == 1) {
            this.back = null;
            this.front = null;
        } else {
            this.front = this.front.getNext();
            this.front.setPrevious(null);
        }
        this.size--;
        return returnData;
    }
    
    public void enQueueBack(T data) {
        if (this.isFull()){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node(data);
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.setNext(newNode);
            newNode.setPrevious(this.back);
            this.back = newNode;
        }
        this.size++;
    }

    public T deQueueBack() {
        if (this.isEmpty()) {
            throw new ArrayStoreException();
        }
        T returnData = this.back.getData();
        if (this.size == 1) {
            this.back = null;
            this.front = null;
        } else {
            this.back = this.back.getPrevious();
            this.back.setNext(null);
        }
        this.size--;
        return returnData;
    }
}
