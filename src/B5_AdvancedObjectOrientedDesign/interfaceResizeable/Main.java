package B5_AdvancedObjectOrientedDesign.interfaceResizeable;

public class Main {
    public static void main(String[] args) {
        Shape h[] = new Shape[3];
        h[0] = new Circle(5);
        h[1] = new Rectangle(7, 19);
        h[2] = new Square(9);
        for (Shape s : h) {
            System.out.println(s.toString());
        }
        for (Shape s : h) {
            if (s instanceof Circle) {
                s = ((Circle) s).resize(rd());
            }
            if (s instanceof Rectangle) {
                s = ((Rectangle) s).resize(rd());
            }
            if (s instanceof Square) {
                s = ((Square) s).resize(rd());
            }
        }
        System.out.println("Sau khi resize ");
        for (Shape s : h) {
            System.out.println(s.toString());
        }
    }
    public static int rd(){
        return (int)Math.random()*100 +1;
    }
}
