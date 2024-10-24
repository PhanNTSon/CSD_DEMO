/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListDemo;

/**
 *
 * @author ADMIN
 */
public class LinkedList {

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void display(String mess) {
        if (this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        System.out.println(mess);
        System.out.print("List: ");
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void add(int index, int data) {
        if (index < 0 || index > this.size - 1) {
            System.out.println("INVALID INDEX");
            return;
        } else if (index == 0) {
            this.addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = this.head;
        Node previous = null;
        int count = 0;
        while (count != index) {
            previous = current;
            current = current.next;
            count++;
        }
        newNode.next = current;
        previous.next = newNode;
    }

    public Node removeFirst() {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        }
        Node returnNode = this.head;
        this.head = this.head.next;
        this.size--;
        return returnNode;
    }

    public Node removeLast() {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        }
        Node returnNode = this.tail;
        Node current = this.head;
        while (current.next != this.tail) {
            current = current.next;
        }
        this.tail = current;
        current.next = null;
        this.size--;
        return returnNode;
    }

    public Node remove(int index) {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        } else if (index < 0 || index > this.size) {
            System.out.println("INVALID INDEX");
            return null;
        }
        Node current = this.head;
        Node previous = null;
        int count = 0;
        while (count != index) {
            previous = current;
            current = current.next;
            count++;
        }
        Node returnNode = current;
        previous.next = current.next;
        this.size--;
        return returnNode;
    }

    public void reverse() {
        Node previous = null;
        Node current = this.head;
        Node next = null;

        while (current != null) {
            // Saving the next Node
            next = current.next;
            // Reverse the link
            current.next = previous;
            // Move up to the next Node
            previous = current;
            current = next;
        }
        // Change head
        this.head = previous;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 > this.size) {
            System.out.println("INVALID INDEX");
            return;
        } else if (index2 < 0 || index2 > this.size) {
            System.out.println("INVALID INDEX");
            return;
        } else if (index1 == index2) {
            System.out.println("INVALID INDEX");
            return;
        }

        Node prev1 = null;
        Node prev2 = null;
        Node curr1 = this.head;
        Node curr2 = this.head;
        int count = 0;

        // Find Node1 at index 1
        while (count != index1) {
            prev1 = curr1;
            curr1 = curr1.next;
            count++;
        }

        // Find Node2 at index 2
        count = 0;
        while (count != index2) {
            prev2 = curr2;
            curr2 = curr2.next;
            count++;
        }

        /*
        If Node 1 is not head then Prev1->next = Node2
        Else head = Node2
        */
        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            this.head = curr2;
        }
        
        /*
        Similar to above
        */
        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            this.head = curr1;
        }
        
        /*
        Switching the link of next Node of Node 1 and Node 2
        */
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
    }
}