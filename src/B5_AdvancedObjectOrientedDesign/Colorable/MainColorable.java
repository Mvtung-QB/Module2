package B5_AdvancedObjectOrientedDesign.Colorable;

public class MainColorable {
    public static void main(String[] args) {
        Shape shape[]= new Shape[3];
        shape[0]= new Circle(3.5);
        shape[1]= new Rectangle(6,9);
        shape[2]= new Square(5);
        for (Shape s : shape) {
            System.out.println(s.toString());
            if (s instanceof Square){
                ((Square) s).howToColor();
            }
        }
    }
}
