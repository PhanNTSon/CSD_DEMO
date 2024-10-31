/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class ArrayDeque {
    private Object[] storage;
    private int size, cap;
    private int front, back;

    public ArrayDeque(int cap) {
        this.cap = cap;
        this.size = 0;
        this.front = -1;
        this.back = -1;
        this.storage = new Object[cap];
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

    public void enQueueFront(Object data) {
        if (this.isFull()) {
            throw new ArrayStoreException("QUEUE FULL");
        } else if (this.isEmpty()) {
            this.front++;
        }
        this.front = (this.cap + (this.front - 1)) % this.cap;
        this.storage[this.front] = data;
        this.size++;
    }

    public Object deQueueFront() {
        // If queue is empty
        if (this.isEmpty()) {
            throw new ArrayStoreException("QUEUE EMPTY");
            
        } else if (this.size == 1){ // If queue have only 1 element
            
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
    
    public void enQueueBack(Object data) {
        // If queue is full
        if (this.isFull()) {
            throw new ArrayStoreException("QUEUE FULL");
            
        } else if (this.isEmpty()) {    // If queue is empty
            this.front++;
        }
        this.back = (this.back + 1) % this.cap;
        this.storage[this.back] = data;
        this.size++;
    }
    
    public Object deQueueBack() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("QUEUE EMPTY");
        } else if (this.size == 1){
            Object returnData = this.storage[this.back];
            this.clear();
            return returnData;
        }
        Object returnData = this.storage[this.back];
        this.storage[this.back] = null;
        this.back = (this.cap + (this.back - 1)) % this.cap;
        this.size--;
        return returnData;
    }
}
