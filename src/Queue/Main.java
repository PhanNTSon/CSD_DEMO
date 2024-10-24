/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
//        LinkedPQueue<Character> myQueue = new LinkedPQueue<>(10000000);
//        for (char i = 'a'; i <= 'z'; i++) {
//            myQueue.display();
//            myQueue.enQueue(i);
//        }
//        myQueue.display();
        ArrayPQueue<Integer> queue = new ArrayPQueue<>(Integer.class,10000);
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        queue.display();
    }
}
