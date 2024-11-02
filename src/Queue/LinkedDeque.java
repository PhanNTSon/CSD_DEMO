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
public class LinkedDeque {

    private Node front;
    private Node back;

    public LinkedDeque(int cap) {
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
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public void enQueueFront(Object data) {

        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            newNode.next = this.front;
            this.front.previous = newNode;
            this.front = newNode;
        }
    }

    public Object deQueueFront() {
        if (this.isEmpty()) {
            return null;
        }
        Object returnData = this.front.data;
        if (this.back == this.front) {
            this.back = null;
            this.front = null;
        } else {
            this.front = this.front.next;
            this.front.previous = null;
        }
        return returnData;
    }

    public void enQueueBack(Object data) {

        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.next = newNode;
            newNode.previous = this.back;
            this.back = newNode;
        }
    }

    public Object deQueueBack() {
        if (this.isEmpty()) {
            return null;
        }
        Object returnData = this.back.data;
        if (this.back == this.front) {
            this.back = null;
            this.front = null;
        } else {
            this.back = this.back.previous;
            this.back.next = null;
        }
        return returnData;
    }
}
