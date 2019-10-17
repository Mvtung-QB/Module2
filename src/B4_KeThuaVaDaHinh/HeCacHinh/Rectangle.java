package B4_KeThuaVaDaHinh.HeCacHinh;

public class Rectangle extends Shape {

    private double weight;
    private double length;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Rectangle(double weight, double length) {
        this.weight = weight;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double weight, double length) {
        super(color, filled);
        this.weight = weight;
        this.length = length;
    }

    public Rectangle() {
        this.weight = 1.0;
        this.length = 1.0;
    }

    public double getArea() {
        return this.weight * this.length;
    }

    public double getPerimeter() {
        return (this.length + this.length) * 2;
    }

    public String toString() {
        return "A Rectangle with width= " + this.weight + " and length= " + this.length + ", which is a subclass of " + super.toString();
    }
}
