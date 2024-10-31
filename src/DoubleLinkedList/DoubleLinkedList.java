/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoubleLinkedList;

/**
 *
 * @author ADMIN
 */
public class DoubleLinkedList {

    private Node header;
    private Node trailer;
    private int size;

    public DoubleLinkedList() {
        this.header = null;
        this.trailer = null;
        this.size = 0;
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object data) {
        Node current = this.header;
        while (current != null) {
            current = current.getNext();
            if (current.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.header = null;
        this.trailer = null;
        this.size = 0;
    }

    public void display(String mess) {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST");
            return;
        }

        Node current = this.header;
        while (current != null) {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode.setNext(this.header);
            this.header.setPrevious(newNode);
            this.header = newNode;
        }
        this.size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode.setPrevious(this.trailer);
            this.trailer.setNext(newNode);
            this.trailer = newNode;
        }
        this.size++;
    }

    public void add(Object data, int index) throws Exception {
        if (index < 0 || index > this.size - 1) {
            throw new Exception("INVALID INDEX");
        } else if (this.isEmpty() || index == 0) {
            this.addFirst(data);
        } else if (index == this.size) {
            this.addLast(data);
        } else {
            Node newNode = new Node(data);
            int count = 0;
            Node current = this.header;

            while (count != index) {
                current = current.getNext();
                count++;
            }

            current.getPrevious().setNext(newNode);
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            this.size++;
        }
    }

    public Object removeFirst() {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        } else if (this.header == this.trailer) {
            Object data = this.header.getData();
            this.clear();
            return data;
        } else {
            Object data = this.header.getData();
            this.header = this.header.getNext();
            this.header.setPrevious(null);
            this.size--;
            return data;
        }

    }

    public Object removeLast() {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        } else if (this.header == this.trailer) {
            Object data = this.header.getData();
            this.clear();
            return data;
        } else {
            Object data = this.trailer.getData();
            this.trailer = this.trailer.getPrevious();
            this.trailer.setNext(null);
            this.size--;
            return data;
        }
    }

    public Object remove(int index) {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        } else if (index < 0 || index > this.size - 1) {
            System.out.println("INVALID INDEX");
            return null;
        } else if (index == 0) {
            return this.removeFirst();
        } else if (index == this.size - 1) {
            return this.removeLast();
        } else {
            Node current = this.header;
            int count = 0;

            while (count != index) {
                current = current.getNext();
                count++;
            }

            Object data = current.getData();
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            this.size--;
            return data;
        }
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 > this.size - 1
                || index2 < 0 || index2 > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }

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
            current = current.getNext();

            count++;
        }

        Object tempData = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tempData);
    }
    
    
}
