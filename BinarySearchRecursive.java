/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchrecursive;

import java.util.Scanner;

/**
 *
 * @author mpeht
 */
public class BinarySearchRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int size, i, num;
        System.out.println("Enter a size of vector");
        size = in.nextInt();
        int vet[] = new int[size];
        System.out.println("Enter the nubers in the vector:");
        for (i = 0; i < vet.length; i++) {
            vet[i] = in.nextInt();
        }
        System.out.println("Enter the number to search in the vector");
        num = in.nextInt();
        System.out.println("Matched position: " + recursiveBinarySearch(vet, 0, (vet.length - 1), num));
    }

    public static int recursiveBinarySearch(int vet[], int left, int right,int num) {
        int aux;

        for (int k = 0; k < vet.length; k++) {
            for (int l = 0; l < vet.length; l++) {
                if (vet[k] <= vet[l]) {
                    aux = vet[l];
                    vet[l] = vet[k];
                    vet[k] = aux;
                }
            }
        }
         int mid = left + (right - left) / 2;
        if (left > right) {
           

            if (vet[mid] == num) {
                return (mid + 1);
            }
            if (vet[mid] < num) {
                left = mid + 1;
                recursiveBinarySearch(vet, left + 1, right, num);
            } else {
                right = mid - 1;
                recursiveBinarySearch(vet, left, right - 1, num);
            }
            
        }
        return mid + 1;
    }
}
