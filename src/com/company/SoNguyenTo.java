package com.company;

import java.util.Scanner;

public class SoNguyenTo {
    /**
     * function check snt
     *
     * @param number
     * @return
     */
    public static boolean check(int number) {
        if (number == 2) {
            return true;
        }
        if (number < 0) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int number = sc.nextInt();
        if (check(number)) {
            System.out.println(number + "  la so nguyen to");
        } else System.out.println(number + " khong phai la so nguyen to");
    }
}
