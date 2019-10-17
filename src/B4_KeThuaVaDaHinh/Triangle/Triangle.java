package B4_KeThuaVaDaHinh.Triangle;

import B4_KeThuaVaDaHinh.HeCacHinh.Shape;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double P = (getSide1() + getSide2() + getSide3()) / 2;
        return Math.sqrt(P * (P - getSide1()) * (P - getSide2()) * (P - getSide3()));
    }

    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    @Override
    public String toString() {
        return super.toString() + "C1= " + getSide1() + "C2= " + getSide2() + "C3= " + getSide3() +
                "Ares= " + getArea() +
                "Perrimeter= " + getPerimeter();
    }
}
