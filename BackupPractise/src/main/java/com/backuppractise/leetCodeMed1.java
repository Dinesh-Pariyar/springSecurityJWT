package com.backuppractise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetCodeMed1 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 1, 2, 5, 3, 1, 2, 1, 1, 1};
        Arrays.sort(arr);
        int coin = 15;
        int max = maxIceCream(arr, coin);
        System.out.println("the boy can buy max " + max + " ice cream with " + coin + " coin");
    }
    public static int maxIceCream(int[] arr, int coins) {
        Arrays.sort(arr);


        int count = 0;
        int temp;
        int prevSum = 0;
        int i = 0;
        while (i != arr.length) {
            temp = arr[i];
            if (prevSum <= coins) {
                prevSum = prevSum + temp;
                if (prevSum <= coins) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }

}
