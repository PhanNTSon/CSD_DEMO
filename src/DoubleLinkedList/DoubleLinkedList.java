/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoubleLinkedList;

import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class DoubleLinkedList {

    private Node header;
    private Node trailer;

    public DoubleLinkedList() {
        this.header = null;
        this.trailer = null;
    }

    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    public Node getTrailer() {
        return trailer;
    }

    public void setTrailer(Node trailer) {
        this.trailer = trailer;
    }

    public boolean isEmpty() {
        return this.header == this.trailer;
    }

    public boolean contains(Object data) {
        Node current = this.header;
        while (current != null) {
            current = current.next;
            if (current.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.header = null;
        this.trailer = null;
    }

    public void display(String mess) {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST");
            return;
        }

        Node current = this.header;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode.next = this.header;
            this.header.previous = newNode;
            this.header = newNode;
        }
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode.previous = this.trailer;
            this.trailer.next = newNode;
            this.trailer = newNode;
        }
    }

    public void add(Object data, int index) throws Exception {
        if (this.isEmpty() || index == 0) {
            this.addFirst(data);
        } else {
            Node newNode = new Node(data);
            int count = 0;
            Node current = this.header;

            while (count != index) {
                current = current.next;
                count++;
            }

            current.previous.next = newNode;
            newNode.previous = current.previous;
            current.previous = newNode;
            newNode.next = current;
        }
    }

    public Object removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else if (this.header == this.trailer) {
            Object data = this.header.data;
            this.clear();
            return data;
        } else {
            Object data = this.header.data;
            this.header = this.header.next;
            this.header.previous = null;
            return data;
        }

    }

    public Object removeLast() {
        if (this.isEmpty()) {
            return null;
        } else if (this.header == this.trailer) {
            Object data = this.header.data;
            this.clear();
            return data;
        } else {
            Object data = this.trailer.data;
            this.trailer = this.trailer.previous;
            this.trailer.next = null;
            return data;
        }
    }

    public Object remove(int index) {
        if (this.isEmpty()) {
            return null;
        } else if (index == 0) {
            return this.removeFirst();
        } else {
            Node current = this.header;
            int count = 0;

            while (count != index) {
                current = current.next;
                count++;
            }

            Object data = current.data;
            current.previous.next = current.next;
            current.next.previous = current.previous;
            return data;
        }
    }

    public void swap(int index1, int index2) {

        int count = 0;
        Node current = this.header;
        Node node1 = null;
        Node node2 = null;
        while (current != null) {
            if (count == index1) {
                node1 = current;
            }

            if (count == index2) {
                node2 = current;
            }
            current = current.next;

            count++;
        }

        Object tempData = node1.data;
        node1.data = node2.data;
        node2.data = tempData;
    }

    public void swap(Node a, Node b) {
        Object temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public void sort(Comparator<Object> c) {
        for (Node i = this.header; i != this.trailer; i = i.next) {
            for (Node j = this.header; j != this.trailer; j = j.next) {
                if (c.compare(j.data, j.next.data) > 0) {
                    this.swap(j, j.next);
                }
            }
        }
    }

}
