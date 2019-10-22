package B3_LopVaDoiTuong;

import java.util.Scanner;

public class PhuongTrinhBac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter A");
        double a = sc.nextDouble();
        System.out.println(" enter B");
        double b = sc.nextDouble();
        System.out.println(" enter C");
        double c = sc.nextDouble();
        QuadraticEquation pt = new QuadraticEquation(a, b, c);
        if (pt.getA() == 0) {
            if (pt.getB() == 0) {
                if (pt.getC() == 0) {
                    System.out.println("Vô số nghiệm");
                } else System.out.println("-Vô nghiệm");
            } else System.out.println("Một nghiệm: " + (-1 * pt.getC() / pt.getB()));
        } else {
            if (pt.getDiscriminant() == 0) {
                System.out.println("nghiệm kép: " + pt.getX1());
            } else if (pt.getDiscriminant() > 0) {
                System.out.println("X1= " + pt.getX1() + " X2= " + pt.getX2());
                } else System.out.println(" Vô nghiệm");
        }
    }
}

class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return this.a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return this.b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return this.b * this.b - (4 * this.a * this.c);
    }

    public double getX1() {
        return (-1 * this.b - Math.sqrt(getDiscriminant())) /( 2 * this.a);
    }

    public double getX2() {
        return (-1 * this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
    }
}