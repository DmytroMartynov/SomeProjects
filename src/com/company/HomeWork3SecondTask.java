package com.company;

import java.util.Arrays;

public class HomeWork3SecondTask {
    public static void main(String[] args) {

        int[] arr = new int[4];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (1+Math.random() * 5);
        }
        System.out.println(Arrays.toString(arr));
        int[] finalArr = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                finalArr[count++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                finalArr[count++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(finalArr));
    }

}
