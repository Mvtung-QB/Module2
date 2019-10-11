package com.company;

import org.omg.CORBA.WStringSeqHelper;

import javax.swing.*;
import java.lang.*;
import java.util.Scanner;
public class PhuogTrinhBac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;
        System.out.println("enter a");
        a = sc.nextInt();
        System.out.println("enter b");
        b = sc.nextInt();
        if (a != 0) {
            System.out.println("x= " + (-b) / a);
        } else if (b == 0) {
            System.out.println("Vo so nghiem");
        } else {
            System.out.println("Vo nghiem");
        }
    }
}
