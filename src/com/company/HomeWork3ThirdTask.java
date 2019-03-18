package com.company;

public class HomeWork3ThirdTask {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        permutationArray(arr);
        changeNumbers(arr);
    }

    public static void permutationArray(int[][] mass) {
        int temp;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length / 2; j++) {
                temp = mass[i][j];
                mass[i][j] = mass[i][mass.length - j - 1];
                mass[i][mass.length - j - 1] = temp;
            }
        }
    }

    public static void changeNumbers(int[][] numb) {
        for (int i = 0; i < numb.length; i++) {
            for (int j = 0; j < numb.length; j++) {
                if (numb[i][j] == 1) {
                    numb[i][j] = 0;
                } else if (numb[i][j] == 0) {
                    numb[i][j] = 1;
                }
                System.out.print(numb[i][j] + " ");
            }
            System.out.println();
        }
    }
}
