package com.company.session1;
import java.util.Scanner;
public class ChuyenDoiTienTe {
    static double USDtoVND(double USD){
        return USD*23000;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your money(USD)");
        double usd = sc.nextDouble();
        System.out.println(usd+ " USD = " + USDtoVND(usd)+ " VND");
    }
}
