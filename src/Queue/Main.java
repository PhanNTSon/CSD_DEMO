/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        ArrayPQueue qe = new ArrayPQueue(100);
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare((Integer) o2, (Integer) o1);
            }
        };
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            qe.enQueue(rand.nextInt(15), c);
        }
        
        qe.display();
    }
}
