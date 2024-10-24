/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sort;

/**
 *
 * @author ADMIN
 */
public class DoubleLinkedList<T extends Comparable<T>> {

    private Node<T> header;
    private Node<T> trailer;
    private int size;

    public DoubleLinkedList() {
        this.header = null;
        this.trailer = null;
        this.size = 0;
    }

    public Node<T> getHeader() {
        return header;
    }

    public void setHeader(Node<T> header) {
        this.header = header;
    }

    public Node<T> getTrailer() {
        return trailer;
    }

    public void setTrailer(Node<T> trailer) {
        this.trailer = trailer;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(T data) {
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

        System.out.println(mess);
        System.out.print("List: ");
        Node current = this.header;
        while (current != null) {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void addFirst(T data) {
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

    public void addLast(T data) {
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

    public void add(T data, int index) throws Exception {
        if (index < 0 || index > this.size - 1) {
            throw new Exception("INVALID INDEX");
        } else if (this.isEmpty() || index == 0) {
            this.addFirst(data);
        } else if (index == this.size) {
            this.addLast(data);
        } else {
            Node<T> newNode = new Node(data);
            int count = 0;
            Node<T> current = this.header;

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

    public T removeFirst() {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        } else if (this.header == this.trailer) {
            T data = this.header.getData();
            this.clear();
            return data;
        } else {
            T data = this.header.getData();
            this.header = this.header.getNext();
            this.header.setPrevious(null);
            this.size--;
            return data;
        }

    }

    public T removeLast() {
        if (this.isEmpty()) {
            System.out.println("LIST EMPTY");
            return null;
        } else if (this.header == this.trailer) {
            T data = this.header.getData();
            this.clear();
            return data;
        } else {
            T data = this.trailer.getData();
            this.trailer = this.trailer.getPrevious();
            this.trailer.setNext(null);
            this.size--;
            return data;
        }
    }

    public T remove(int index) {
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
            Node<T> current = this.header;
            int count = 0;

            while (count != index) {
                current = current.getNext();
                count++;
            }

            T data = current.getData();
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
        Node<T> current = this.header;
        Node<T> node1 = null;
        Node<T> node2 = null;
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

        T tempData = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tempData);
    }

    public void swap(Node<T> a, Node<T> b) {
        T temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }

    public void insertionSort() {
        for (Node<T> i = this.header; i != null; i = i.getNext()) {
            for (Node<T> j = i; j != this.header; j = j.getPrevious()) {
                if (j.getPrevious().compareTo(j) > 0) {
                    swap(j.getPrevious(), j);
                } else {
                    break;
                }
            }
        }
    }

    public Node<T> partition(Node<T> low, Node<T> high) {
        // Get pivot
        Node<T> pivot = high;
        
        // Index of Pivot after partition
        Node<T> j = low;
        // Finding correct Index
        for (Node<T> i = low; i != pivot; i = i.getNext()){
            // If i is smaller than Pivot
            if (i.compareTo(pivot) < 0){
                this.swap(i, j);
                j = j.getNext();
            }
        }
        this.swap(j, pivot);
        return j;
    }

    public void quickSort(Node<T> low, Node<T> high) {
        if (low != null && high != null && low != high && low != high.getNext()) {
            this.display("Before partition: ");
            Node<T> pivot = this.partition(low, high);
            this.display("\nAfter partition: ");
            System.out.println(pivot.toString());
            quickSort(low, pivot.getPrevious());
            quickSort(pivot.getNext(), high);
        }
    }
    
    public void quickSort(){
        this.quickSort(this.header, this.trailer);
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(9);
        list.addFirst(99);
        list.addFirst(45);
        list.addFirst(24);
        list.addFirst(2);
        
        list.quickSort();
        list.display("Sorted: ");
    }

}
