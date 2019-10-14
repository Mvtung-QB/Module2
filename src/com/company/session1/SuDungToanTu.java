package com.company.session1;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float weight, height;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter weight");
        weight = sc.nextFloat();
        System.out.println("Enter height");
        height = sc.nextFloat();
        float area = weight * height;
        System.out.println("area = " + area);
    }
}
