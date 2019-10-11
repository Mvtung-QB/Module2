package com.company;
import java.util.*;

public class TimSoNgayCuaThang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter year");
        int year = sc.nextInt();
        System.out.println("enter month");
        int month = sc.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang co 30  ngay");
                break;
            case 2:
                if ((year%4==0 && year %100 !=0) || year % 400 ==0 ){
                    System.out.println("Nam nhuan thang 2 co 29 ngay");
                }else {
                    System.out.printf("thang co 28 ngay");
                }
                break;
            default:
                System.out.printf("Thang khong dung");
        }
    }
}
