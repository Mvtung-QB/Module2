package com.company.session1;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;
public class InSoNguyenTo {
    public static boolean check(int number) {
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        int num;
        System.out.println("Can in bao nhiu so nguyen to");
        num = sc.nextInt();
        int N=2;
        while (true){
                if (N == 2) {
                    System.out.println(N + " ");
                    sum++;
                    N++;
                    continue;
                }
                if (check(N)) {
                    sum ++;
                    System.out.println(N + " ");
                }
                if (sum == num) break;

                N+=2;
            }
        }
    }
