package com.company;

public class DontUseStringToLowerCase {

    public static void main(String[] args) {

        String str = "#1AMCSaDAsDC";
        char[] charArr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                charArr[i] = Character.toLowerCase(charArr[i]);
            }
            System.out.print(charArr[i]);
        }
    }
}
