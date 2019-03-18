package com.company;

public class FibonachiNumbers {
    public static void main(String[] args) {
        System.out.println(fibonachiNumbers());
    }


    private static int fibonachiNumbers() {
        int count = 0;
        int F0 = 1;
        int F1 = 1;
        int Fn;
        for(int i = 2; i < 10; i++){
            Fn=F0+F1;
            System.out.print(Fn+" ");
            F0=F1;
            F1= Fn;
            count++;
        }
        System.out.println();
        return count;
    }
}

