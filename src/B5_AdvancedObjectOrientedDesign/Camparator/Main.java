package B5_AdvancedObjectOrientedDesign.Camparator;

import B4_KeThuaVaDaHinh.HeCacHinh.Circle;
import B4_KeThuaVaDaHinh.HeCacHinh.Rectangle;
import B4_KeThuaVaDaHinh.HeCacHinh.Square;

import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // -- circle
        Circle[] circles = new Circle[6];
        circles[0] = new Circle();
        circles[1] = new Circle("green", true, 1.5);
        circles[2] = new Circle("green", true, 1.2);
        circles[3] = new Circle("green", true, 1);
        circles[4] = new Circle("green", true, 0.5);
        circles[5] = new Circle("green", true, 5.5);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }


        CircleComparator circleComparator = new CircleComparator();
        circleComparator.sortCircle(circles);
        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        //--- Rectanger
        Rectangle rectangle[] = new Rectangle[6];
        rectangle[0] = new Rectangle();
        rectangle[1] = new Rectangle(12, 5);
        rectangle[2] = new Rectangle(16, 4);
        rectangle[3] = new Rectangle(5, 45);
        rectangle[4] = new Rectangle(41, 5);
        rectangle[5] = new Rectangle(5, 5);

        System.out.println("Pre-sorted:");
        for (Rectangle r : rectangle) {
            System.out.println(r);
        }
        circleComparator.sortRectanger(rectangle);
        System.out.println("After-sorted:");
        for (Rectangle r : rectangle) {
            System.out.println(r);
        }
        //--- Square
        Square square[] = new Square[6];
        square[0] = new Square();
        square[1] = new Square(15);
        square[2] = new Square(16);
        square[3] = new Square(45);
        square[4] = new Square(41);
        square[5] = new Square(5);

        System.out.println("Pre-sorted:");
        for (Square r : square) {
            System.out.println(r);
        }
        circleComparator.sortSquare(square);
        System.out.println("After-sorted:");
        for (Square r : square) {
            System.out.println(r);
        }

    }
}
