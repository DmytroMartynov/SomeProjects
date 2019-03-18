package com.company;

public class RobotTask {


    public static void main(String[] args) {
        String str = "URDL";
        System.out.println(HardRobot(str));
    }

    private static boolean HardRobot(String line) {
        int horizontal = 0;
        int vertical = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'U') {
                vertical++;

            } else if (line.charAt(i) == 'D') {
                vertical--;

            } else if (line.charAt(i) == 'R') {
                horizontal++;

            } else if (line.charAt(i) == 'L') {
                horizontal--;

            }
        }
        return horizontal == 0 && vertical == 0;

    }
}
