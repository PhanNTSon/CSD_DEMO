/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoubleLinkedList;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        do {
            try {
                DoubleLinkedList<Integer> dlkl = new DoubleLinkedList();
                int limit = 10;

                for (int i = 0; i < limit; i++) {
                    dlkl.addFirst(rand.nextInt(100));
                }
                dlkl.display("STANDARD LIST");

                int index = 0;
                int index1 = dlkl.getSize()-1;
                
                dlkl.swap(index1, index);
                dlkl.display("SWAP INDEX " + index1 + "-" + index);
                dlkl.swap(index, index1);
                dlkl.display("SWAP INDEX " + index + "-" + index1);
            } catch (Exception e) {
                System.out.println(e.getCause());
            }

        } while (sc.nextLine().compareToIgnoreCase("y") == 0);

    }
}
