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
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public void clear(){
        this.top = null;
        this.size = 0;
    }
    
    public void display(){
        for (Node i = this.top; i != null; i = i.getNext()) {
            System.out.print(i.getData() + " ");
        }
    }
    
    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(this.top);
        this.top = newNode;
        this.size ++;
    }
    
    public Object pop(){
        if (this.isEmpty()) {
            throw new ArrayStoreException("STACK EMPTY");
        }
        Object data = this.top.getData();
        this.top = this.top.getNext();
        this.size--;
        return data;
    }
    
    public Object peek(){
        if (this.isEmpty()) {
            throw new ArrayStoreException("STACK EMPTY");
        }
        Object data = this.top.getData();
        return data;
    }
    
    public int search(Object data){
        if (this.isEmpty()) {
            throw new ArrayStoreException("STACK EMPTY");
        }
        
        int count = 0;
        Node current = this.top;
        while (current != null) {
            if (current.getData() == data){
                return count;
            }
            current = current.getNext();
            count++;
        }
        return -1;
    }
}
