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
public class ArrayDeque<T extends Comparable<T>> {
    private T[] storage;
    private int size, cap;
    private int front, back;

    public ArrayDeque(int cap) {
        this.cap = cap;
        this.size = 0;
        this.front = -1;
        this.back = -1;
        this.storage = (T[]) new Object[cap];
    }

    public T[] getStorage() {
        return storage;
    }

    public void setStorage(T[] storage) {
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
        this.storage = (T[]) new Object[this.cap];
        this.size = 0;
        this.front = -1;
        this.back = -1;
    }

    public void enQueueFront(T data) {
        if (this.isFull()) {
            throw new ArrayStoreException("QUEUE FULL");
        } else if (this.isEmpty()) {
            this.front++;
        }
        this.front = (this.cap + (this.front - 1)) % this.cap;
        this.storage[this.front] = data;
        this.size++;
    }

    public T deQueueFront() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("QUEUE EMPTY");
        } else if (this.size == 1){
            T returnData = this.storage[this.front];
            this.clear();
            return returnData;
        }
        T returnData = this.storage[this.front];
        this.storage[this.front] = null;
        this.front = (this.front + 1) % this.cap;
        this.size--;
        return returnData;
    }
    
    public void enQueueBack(T data) {
        if (this.isFull()) {
            throw new ArrayStoreException("QUEUE FULL");
        } else if (this.isEmpty()) {
            this.front++;
        }
        this.back = (this.back + 1) % this.cap;
        this.storage[this.back] = data;
        this.size++;
    }
    
    public T deQueueBack() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("QUEUE EMPTY");
        } else if (this.size == 1){
            T returnData = this.storage[this.back];
            this.clear();
            return returnData;
        }
        T returnData = this.storage[this.back];
        this.storage[this.back] = null;
        this.back = (this.cap + (this.back - 1)) % this.cap;
        this.size--;
        return returnData;
    }
}
