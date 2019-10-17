package B4_KeThuaVaDaHinh;

class Circle1{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;

    public Circle1(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public Circle1() {
    }
    public double getArea(){
        return Math.PI* this.radius*this.radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*this.radius;
    }
    public String toString(){
        return "Radius : "+ getRadius()+ " Color: "+ getColor();
    }
}
class Cylinder extends Circle1{
    private double height;

    public Cylinder() {
        this.height= 1.0;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public Cylinder(double height) {
        this.height = height;
    }
    public double getNoun(){
        return getArea()*this.height;
    }
    public  String toString(){
        return super.toString()+ " Nuoun = "+ getNoun()  ;
    }
}
public class LopCircleVaCylinder {
    public static void main(String[] args) {
        Circle1 circle1 = new Circle1("green",5) ;
        System.out.println(circle1.toString());
        Cylinder cylinder = new Cylinder("green",10,5);
        System.out.println(cylinder.toString());
    }
}
