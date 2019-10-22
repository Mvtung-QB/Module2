package B5_AdvancedObjectOrientedDesign.Camparator;

import B4_KeThuaVaDaHinh.HeCacHinh.Circle;
import B4_KeThuaVaDaHinh.HeCacHinh.Rectangle;
import B4_KeThuaVaDaHinh.HeCacHinh.Square;

class CircleComparator implements Comparable {
    @Override
    public int circleComparator(Circle c1, Circle c2) {
        if (c1.getRadius() <= c2.getRadius())
            return -1;
        else if (c1.getRadius() == c2.getRadius())
            return 0;
        else return 1;
    }

    @Override
    public int rectangleComparator(Rectangle c1, Rectangle c2) {
        if (c1.getLength() <= c2.getLength())
            return -1;
        else if (c1.getLength() == c2.getLength())
            return 0;
        else return 1;
    }

    @Override
    public int squareComparator(Square c1, Square c2) {
        if (c1.getLength() <= c2.getLength())
            return -1;
        else if (c1.getLength() == c2.getLength())
            return 0;
        else return 1;
    }
    public void sortRectanger(Rectangle [] arr) {
        Rectangle temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (this.rectangleComparator(arr[i] , arr[j])== -1 ){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public void sortSquare(Square [] arr) {
        Square temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (this.squareComparator(arr[i] , arr[j])== -1 ){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public void sortCircle(Circle [] arr) {
        Circle temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (this.circleComparator(arr[i] , arr[j])== -1 ){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
