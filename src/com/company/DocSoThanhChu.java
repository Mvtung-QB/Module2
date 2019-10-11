package com.company;

import java.util.*;

public class DocSoThanhChu {
    public static String docSo1Den10(int number) {
        String n = new String();
        switch (number) {
            case 1:
                n = "one";
                break;
            case 2:
                n = "two";
                break;
            case 3:
                n = "Three";
                break;
            case 4:
                n = "four";
                break;
            case 5:
                n = "five";
                break;
            case 6:
                n = "six";
                break;
            case 7:
                n = "seven";
                break;
            case 8:
                n = "eight";
                break;
            case 9:
                n = "night";
                break;
            case 10:
                n = "ten";
                break;
        }
        return n;
    }
    public static String docSo11Den20(int number) {
        String n = new String();
        switch (number) {
            case 11:
                n = "elevent";
                break;
            case 12:
                n = "twelve";
                break;
            case 13:
                n = "thirteen";
                break;
            case 14:
                n = "fourteen";
                break;
            case 15:
                n = "fifteen";
                break;
            case 16:
                n = "sixteen";
                break;
            case 17:
                n = "seventeen";
                break;
            case 18:
                n = "eightteen";
                break;
            case 19:
                n = "nightteen";
                break;
            case 20:
                n = "twenty";
                break;
        }
        return n;
    }
    public static String docSo21Den99(int number){
        String n= new String();
        int num1= number%10;
        int num2= number /10;
        if (num1==0){
             n= docSo1Den10(number)+"ty";
        }else {
            n=docSo1Den10(num2)+"ty"+ " "+docSo1Den10(num1);
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int number = sc.nextInt();
        if (number > 0 && number <= 10) {
            System.out.println(docSo1Den10(number));
        } else if (number > 10 && number <= 20) {
            System.out.println(docSo11Den20(number));
        }

    }
}
