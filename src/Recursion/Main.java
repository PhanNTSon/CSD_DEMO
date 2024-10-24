/*
 * toRodlick nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * toRodlick nbfs://nbhost/SystemFileSystem/Templates/toRodlasses/toRodlass.java to edit this template
 */
package Recursion;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fromRodDMIN
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
//        R1(10);
//        System.out.println();
//        R2(10);
//        System.out.println();
//        R3(10, 1);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        R4(arr, 0);
//        System.out.println();
//        System.out.println("index:" + 
//                binarySearch(arr, 10000, 0, arr.length - 1));
//        towerOfHanoi(3, 'A', 'C', 'B');
        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int n = sc.nextInt();
        System.out.println("INDEX: " + binarySearch(arr, n, 0, arr.length - 1));
    }

    /**
     *
     * @param n
     * @return
     * @throws java.lang.Exception
     */
    public static int sum(int n) throws Exception {
        if (n == 1) {
            return 1;
        } else {
            return sum(n - 1) + n;
        }
    }

    /**
     * Print from 2^n -> 1
     *
     * @param n
     */
    public static void R1(int n) {
        if (n == 0) {
            System.out.print("1 ");
        } else {
            System.out.print((int) Math.pow(2, n) + " ");
            R1(n - 1);
        }
    }

    public static int R2(int n) {
        if (n == 0) {
            System.out.print("1 ");
            return 1;
        } else {
            int out = R2(n - 1) * 2;
            System.out.print(out + " ");
            return out;
        }
    }

    public static void R3(int n, int i) {
        if (n > 0) {
            R3s(i);
            System.out.println();
            R3(n - 1, i + 1);
        }
    }

    public static void R3s(int i) {
        if (i > 0) {
            System.out.print("* ");
            R3s(i - 1);
        }
    }

    public static void R4(int[] arr, int i) {
        if (i < arr.length) {
            System.out.print(arr[i] + " ");
            R4(arr, i + 1);
        }
    }

    public static void R5(int[] arr, int low, int high) {
        if (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            R5(arr, low + 1, high - 1);
        }
    }

    public static int binarySearch(int[] arr, int n, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (arr[mid] == n) {
            return mid;
        } else if (n > arr[mid]) {
            return binarySearch(arr, n, mid + 1, high);
        } else {
            return binarySearch(arr, n, low, mid - 1);
        }

    }

    public static int fibonanci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return fibonanci(n - 1) + fibonanci(n - 2);
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    /**
     * To solve this problem, we need to divide the problem into smaller problem
     * that if we have n disks in rod A and need to move it to rod C then we
     * will need to move n-1 disks from A to B. After we have moved n-1 disks
     * from A to B then problem become simple when there is only 1 disk from A
     * to C. And the problem continue to solve by itself when moving n-1 disks
     * from B to C by moving the next n-2 disks from B to A and only 1 left in
     * B. So in simple: Move n-1 from A to B then move 1 from A to C. After that
     * repeat itself by changing the role of A and B.
     *
     * @param n
     * @param fromRod
     * @param toRod
     * @param supRod
     */
    public static void towerOfHanoi(int n, char fromRod, char toRod, char supRod) {
        if (n == 1) {                       // Base case, only 1 disks left
            System.out.println("Move 1 from " + fromRod + " to " + toRod);
            return;
        }
        // Move the current disks to the support rod
        towerOfHanoi(n - 1, fromRod, supRod, toRod);
        System.out.println("Move " + n + " from " + fromRod + " to " + toRod);

        // Move disks from support rod to final rod
        towerOfHanoi(n - 1, supRod, toRod, fromRod);
    }

    /**
     * Quick Sort Algorithm using an element in it as a pivot, then moving all
     * larger elements to the right and all smaller to the left.After that,
     * recursion with the right side and left side of the array. Base case is
     * when low and high is equal.
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        // While it's not base case
        if (low < high) {
            int pivot = getPivotIndex(arr, low, high);  // Get pivot's index
            quickSort(arr, low, pivot - 1);             // Sort left part
            quickSort(arr, pivot + 1, high);            // Sort right part
        }
    }

    /**
     * Take a random element in the array as a pivot.Moving all the smaller
     * elements to the left of the pivot, all bigger elements to the right by
     * swapping it with the pivot. Giving back the index of the pivot after
     * swapping all elements.
     *
     * @param arr
     * @param low
     * @param high
     * @return index of Pivot
     */
    public static int getPivotIndex(int[] arr, int low, int high) {
        // Take pivot as the last value 
        int pivot = arr[high];
        // Storing the index of correct standing value which smaller than pivot
        int correctIndex = low - 1;

        // Iteration through array 
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                correctIndex++; // Update the current correct Index
                // Swap
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
        }
        /*
        Increase correctIndex 1 to get get the next index of the last corret
        value that is smaller than pivot
         */
        correctIndex++;
        // Swapping the pivot to the correctIndex
        int temp = arr[correctIndex];
        arr[correctIndex] = arr[high];
        arr[high] = temp;
        return correctIndex;
    }

    /**
     * Merger Sort Algorithm. First, divided array into 2 part left and right.
     * Then recursion divided step until the array only contains 1 element.
     * After that, merge back into one. During merging, compare each elements in
     * both left and right part to get the correct element to put in.
     *
     * @param array
     * @param low
     * @param high
     */
    public static void mergeSort(int[] array, int low, int high) {
        // If low < high means there are more than 1 elements in array
        if (low < high) {
            // Calculate the mid index 
            int mid = (low + high) / 2;
            // Recursion with the left part
            mergeSort(array, low, mid);
            // Recursion with the right part
            mergeSort(array, mid + 1, high);
            // Merge left and right array back together
            mergeArray(array, low, mid, high);
        }
    }

    /**
     * Merge Arrays. Create 2 temporary arrays that hold elements of 2 side left
     * and right. Then compare each elements of 2 arrays to rearrange in the
     * current array.
     *
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    public static void mergeArray(int[] array, int low, int mid, int high) {
        // Initate left temp array capacity
        int leftCap = mid - low + 1;
        int rightCap = high - mid;
        // Initate left right array capacity
        // Initiate left temp array
        int[] tempLeft = new int[leftCap];
        // Initiate right temp array
        int[] tempRight = new int[rightCap];
        // Copy all left elements to left temp array
        for (int i = 0; i < leftCap; i++) {
            tempLeft[i] = array[i + low];
        }
        // Copy all right elements to right temp array
        for (int i = 0; i < rightCap; i++) {
            tempRight[i] = array[i + mid + 1];
        }
        // Initiate variable i to loop through left temp array
        int i = 0;
        // Initiate variable j to loop through right temp array
        int j = 0;
        // Initiate variable k to loop through real array
        int k = low;
        /*
        Begin iteration through both array using i and j to compare each 
        elements.
        After compare, take the correct element then put in k. 
        Increase k and the index of which the array have been taken.
         */
        while (i < leftCap && j < rightCap) {
            // Compare two elements at index i and j
            if (tempLeft[i] <= tempRight[j]) {
                // Put into index k
                array[k] = tempLeft[i];
                // If element from left temp array, increase i
                i++;
            } else {
                // Put into index k
                array[k] = tempRight[j];
                // If element from right temp array, increase j
                j++;
            }
            // Increase index k   
            k++;
        }

        // If left temp array have remains, push all to real array
        while (i < leftCap) {
            array[k] = tempLeft[i];
            i++;
            k++;
        }
        // If right temp array have remains, push all to real array
        while (j < rightCap) {
            array[k] = tempRight[j];
            k++;
            j++;
        }
    }

    /**
     * Binary Search Algorithm. First, take the middle elements and compare it
     * with searching number. Then, divide array into 2 parts. If it's equal,
     * then return the index. If it's larger then recursion previous step with
     * right part. If it's smaller then recursion with left part. All elements
     * in the array must be sorted first. If the array only contains 1 elements
     * but not equal with the searching number then return -1.
     *
     * @param arr
     * @param n
     * @param low
     * @param high
     * @return index
     */
    public static int binarySearchRecursion(int[] arr, int n, int low, int high) {
        /*
        If there are more than 1 element in array then continue recursion else
        if the only element in the array does'nt equal then return -1
         */
        if (low < high) {
            // Variable ind holds index of middle elements
            int ind = (high + low) / 2;
            // Variable mid is the middle element value
            int mid = arr[ind];
            // Comapre it with n if equal then return ind
            if (mid == n) {
                return ind;
                // If it's larger then recursion with right part
            } else if (mid > n) {
                return binarySearch(arr, n, ind + 1, high);
                // If it's smaller then recursion with left part
            } else {
                return binarySearch(arr, n, low, ind - 1);
            }

        } else if (arr[low] != n) {
            return -1;
        } else {
            return low;
        }
    }
    
    /**
     * 
     */
}
