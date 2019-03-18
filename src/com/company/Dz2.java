package com.company;

public class Dz2 {

    private static String jewels = "aAb";
    private static String stones = "caсAcA";

    public static void main(String[] args) {
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {

        char[] charArrJewels = jewels.toCharArray();
        char[] charArrStones = stones.toCharArray();
        int countJew = 0;

        for (int i = 0; i < charArrJewels.length; i++) {
            for (int j = 0; j < charArrStones.length; j++) {
                if (charArrJewels[i] == charArrStones[j]) {
                    countJew++;
                }
            }
        }
        return countJew;
    }
}







