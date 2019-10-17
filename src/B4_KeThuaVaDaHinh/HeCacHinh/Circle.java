package B4_KeThuaVaDaHinh.HeCacHinh;

public class Circle extends Shape {
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    public Circle(){
        this.radius = 1.0;
    }
    public double getArea(){
        return Math.PI* this.radius*this.radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*this.radius;
    }
    public String toString(){
    return "A Circle with radius="+ this.radius+ ", which is a subclass of "+ super.toString();
    }
}
