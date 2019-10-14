package com.company.session1;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import  java.util.*;
public class Menu {
    public static void tamGiac(){
        for (int i=0; i<10; i++){
            for (int j=0; j<10-i;j++){
                System.out.print(" * ");
            }
            System.out.println("\n");
        }
    }
    public static void hinhVuong(){
        for (int i=0; i<10; i++){
            for (int j=0; j<10;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void hinhChuNhat(){
        for (int i=0; i<10; i++){
            for (int j=0; j<7;j++){
                System.out.print(" * ");
            }System.out.println();
        }
    }
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----menu-------\n" +
                           "1: ve hinh tam giac\n" +
                           "2: ve hinh vuong\n" +
                           "3: ve hinh chu nhat\n" +
                           "4: exit \n" + "");
        System.out.println("enter your choice");
        int x= sc.nextInt();
        choice(x);
    }
    public static void choice(int n){
        switch (n){
            case 1: tamGiac();
            break;
            case 2: hinhVuong();
            break;
            case 3: hinhChuNhat();
            break;
            case 4: System.exit(0);
            default:
                System.out.println("no choice");
        }
    }
    public static void main(String[] args) {
        menu();
    }
}
