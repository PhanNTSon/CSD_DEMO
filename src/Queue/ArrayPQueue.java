/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import java.lang.reflect.Array;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class ArrayPQueue<T extends Comparable<T>> {
    private T[] storage;
    private int size, cap;
    private int front, back;

    public ArrayPQueue(Class<T> clazz, int cap) {
        this.cap = cap;
        this.size = 0;
        this.front = -1;
        this.back = -1;
        this.storage = (T[]) Array.newInstance(clazz,this.cap);
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

    /**
     * Adding new Element to Queue.
     * First check if queue is full or empty or neither two.
     * Then, move index's back forward to 1. After that, moving to the head of
     * Queue and while doing so, copy the next Element to current Element so 
     * when the correct location of new Element is founded, all the previous
     * Element will have been push to the end.
     * @param data 
     */
    public void enQueue(T data) {
        // If Queue is full
        if (this.isFull()) {
            throw new ArrayStoreException("QUEUE FULL");
        } else if (this.isEmpty()) {        // If Queue is empty
            this.front++;
        }
        // Moving index back forward to 1
        this.back = (this.back + 1) % this.cap;
        // Initiate the correct of new Element
        int i = this.back;
        // Moving backward to the head to find correct location of new Element
        while (i != this.front && data.compareTo(this.storage[(this.cap + i - 1) % this.cap]) > 0) {
            // Copy the next Data and store it into current data as push down
            this.storage[i] = this.storage[(this.cap + i - 1) % this.cap];
            // Moving i backward
            i = (this.cap + i - 1) % this.cap;
        }
        // After found the correct locations, put new Element in
        this.storage[i] = data;
        // Increase the current size of Queue
        this.size++;
    }

    public T deQueue() {
        if (this.isEmpty()) {
            throw new ArrayStoreException("QUEUE EMPTY");
        } else if (this.size == 1) {
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
}
