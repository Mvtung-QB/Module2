package com.company.session1;

public class InCacHinh {
    public static void tamGiacCan() {
        for (int n = 1; n <12; n++) {
            for (int i = n; i <=11; i++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n*2 -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        tamGiacCan();
    }
}
