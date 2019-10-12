package com.company;
import java.util.*;
public class TinhLaiNganHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = 1.0;
        int month = 1;
        double interset_rate = 1.0;
        System.out.println("money: ");
        money = sc.nextDouble();
        System.out.println("month");
        month = sc.nextInt();
        System.out.println("rate");
        interset_rate= sc.nextDouble();
        double total = money * (interset_rate/100)/12 *month;
        System.out.println(total);
    }
}