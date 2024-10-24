/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListDemo;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        LinkedList lkl = new LinkedList();
        
        // Add 10 elements to LinkedList
        for (int i = 0; i < 10; i++) {
            lkl.addLast(rand.nextInt(100));
        }
        
        // Display List
        lkl.display("Standard list");
        System.out.println();
        
        // Remove first Element
        lkl.removeFirst();
        lkl.display("Remove first");
        System.out.println();
        
        // Remove last Element
        lkl.removeLast();
        lkl.display("Remove last");
        System.out.println();
        
        // Remove Element at index 2
        lkl.remove(2);
        lkl.display("Remove at index 2");
        System.out.println();
        
        // Add new Element at first
        lkl.addFirst(rand.nextInt(100));
        lkl.display("Add first");
        System.out.println();
        
        // Add new Element at last
        lkl.addLast(rand.nextInt(100));
        lkl.display("Add last");
        System.out.println();
        
        // Add new Element at random index
        int index = rand.nextInt(lkl.size);
        lkl.add(index, rand.nextInt(100));
        lkl.display("Add new at index " + index + ":");
        System.out.println();
        
        // Reverse list
        lkl.reverse();
        lkl.display("Reverse list:");
        System.out.println();
        
        // Swap 2 Elements
        int index1 = rand.nextInt(lkl.size);
        int index2 = rand.nextInt(lkl.size);
        lkl.swap(index1, index2);
        lkl.display("Swap " + index1 + " - " + index2 + ":");
        System.out.println();
    }
}
