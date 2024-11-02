/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

/**
 *
 * @author ADMIN
 */
public class LinkedStack {

    private Node top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public void display() {
        for (Node i = this.top; i != null; i = i.next) {
            System.out.print(i.data + " ");
        }
    }

    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    public Object pop() {

        Object data = this.top.data;
        this.top = this.top.next;
        this.size--;
        return data;
    }

    public Object peek() {

        Object data = this.top.data;
        return data;
    }

    public int search(Object data) {
        if (this.isEmpty()) {
            return -1;
        }

        int count = 0;
        Node current = this.top;
        while (current != null) {
            if (current.data == data) {
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }
}
