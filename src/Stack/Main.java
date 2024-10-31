/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        LinkedStack lStack = new LinkedStack();
        
        lStack.push(15);
        lStack.push(11);
        lStack.push(4435);
        lStack.push(1);
        lStack.push(12);
        
        lStack.display();
        System.out.println();
        
        System.out.println(lStack.pop());
        lStack.display();
        
        System.out.println(lStack.peek());
        System.out.println();
        
        System.out.println(lStack.search(11));
    }
}
