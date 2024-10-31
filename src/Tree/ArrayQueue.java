/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;


/**
 *
 * @author ADMIN
 */
public class ArrayQueue {

    private Object[] storage;
    private int size, cap;
    private int front, back;

    public ArrayQueue(int cap) {
        this.cap = cap;
        this.size = 0;
        this.front = -1;
        this.back = -1;
        this.storage = (Object[]) new Object[cap];
    }

    public Object[] getStorage() {
        return storage;
    }

    public void setStorage(Object[] storage) {
        this.storage = storage;
    }

    public int getSize() {
        return size;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getFront() {
        return front;
    }

    public int getLast() {
        return back;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.cap;
    }

    public Object get(int index){
        if (index > this.size || index < 0){
            return null;
        }
        return this.storage[index];
    }
    
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.storage[(this.front + i) % this.cap] + " ");
        }
        System.out.println();
    }

    public void clear() {
        this.storage = new Object[this.cap];
        this.size = 0;
        this.front = -1;
        this.back = -1;
    }

    public void enQueue(Object data) {
        if (this.isFull()) {
            throw new ArrayStoreException("QUEUE FULL");
        } else if (this.isEmpty()) {
            this.front++;
        }
        this.back = (this.back + 1) % this.cap;
        this.storage[this.back] = data;
        this.size++;
    }

    public Object deQueue() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("QUEUE EMPTY");
        } else if (this.size == 1){
            Object returnData = this.storage[this.front];
            this.clear();
            return returnData;
        }
        Object returnData = this.storage[this.front];
        this.storage[this.front] = null;
        this.front = (this.front + 1) % this.cap;
        this.size--;
        return returnData;
    }

}
