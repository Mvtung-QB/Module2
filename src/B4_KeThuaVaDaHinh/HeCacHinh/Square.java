package B4_KeThuaVaDaHinh.HeCacHinh;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public void setSide(double side) {
        setWeight(side);
    }

    public double getSide() {
        return getWeight();
    }

    public void setWeight(double side) {
        setSide(side);
    }

    public void setLength(double side) {
        setSide(side);
    }

    public String toString() {
        return "A Square with side="+ getSide()+ ", which is a subclass of "+ super.toString();
    }
}
