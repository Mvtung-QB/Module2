package com.company.session1;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.*;
public class DocSoThanhChu {
    /**
     * function doc so tu 1 den 10
     * @param number
     * @return
     */
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
    /**
     * methods doc so tu 11 den 19
     * @param number
     * @return
     */
    public static String docSo11Den19(int number) {
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
        }
        return n;
    }
    /**
     * methods doc so tu 20 den 29
     * @param number
     * @return
     */
    public static String docSo20Den29(int number) {
        int x= number%20;
        return "twenty "+docSo1Den10(x);
    }
    /**
     * methods doc so tu 30 den 39
     * @param number
     * @return
     */
    public static String docSo30Den39(int number) {
        int x= number%30;
        return "thirty "+docSo1Den10(x);
    }
    /**
     * methods doc so tu 50 den 59
     * @param number
     * @return
     */
    public static String docSo50Den59(int number) {
        int x= number%50;
        return "fifty "+docSo1Den10(x);
    }
    public static String docSo2ChuSo(int number){
        String n;
        int num1= number%10;
        int num2= number /10;
        if (number >=20 && number <= 29){
            n= docSo20Den29(number);
        }else if (number >=30 && number <=39){
            n= docSo30Den39(number);
        }else if (number>=50 && number<59){
            n= docSo50Den59(number);
        } else if (num1==0){
            n= docSo1Den10(num2)+"ty";
        }else {
            n=docSo1Den10(num2)+"ty "+docSo1Den10(num1);
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int number = sc.nextInt();
        if (number > 0 && number <= 10) {
            System.out.println(docSo1Den10(number));
        } else if (number > 10 && number <= 19) {
            System.out.println(docSo11Den19(number));
        }else if (number>=20 && number<=99){
            System.out.println(docSo2ChuSo(number));
        }else if (number %100==0){
            int i=number/100;
            System.out.println(docSo1Den10(i)+" hunderes");
        }else{
            int a= number/100;
            int  a1=number%100;
            int b= a1/10;
            int c;
            if (a1>10){
                c= b % 10;
            }else{
                c=a1;
            }
            if (b==0){
                System.out.println(docSo1Den10(a)+" huderes and " + docSo1Den10(c));
            }else {
                System.out.println(docSo1Den10(a)+" hunderes and "+docSo2ChuSo(a1) );
            }
        }
    }
}
