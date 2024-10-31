/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;


/**
 *
 * @author ADMIN
 */
public class ArrayStack {

    private Object storager[];
    private int size;
    private int cap;
    private int top;

    public ArrayStack(int cap) {
        this.size = 0;
        this.storager = new Object[cap];
        this.cap = cap;
        this.top = -1;
    }

    public Object[] getStorager() {
        return storager;
    }

    public int getSize() {
        return size;
    }

    public int getCap() {
        return cap;
    }

    public int getTop() {
        return top;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear(){
        this.size = 0;
        this.storager = new Object[this.cap];
        this.top = -1;
    }
    
    public void display(){
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.storager[this.size - i - 1] + ", ");
        }
    }

    public void push(Object data) {
        if (this.cap == this.size) {
            throw new ArrayStoreException("STACK IS FULL");
        }
        this.top++;
        this.storager[top] = data;
        this.size++;
    }

    public Object pop() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("STACK EMPTY");
        }
        Object data = this.storager[top];
        this.storager[top] = null;
        this.size--;
        this.top--;
        return data;
    }

    public Object peek() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("STACK EMPTY");
        }
        return this.storager[top];
    }
}
