package B4_KeThuaVaDaHinh.PointVaMovablePoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint movablePoint=  new MovablePoint();
        movablePoint.setX(10);
        movablePoint.setY(5);
        System.out.println(movablePoint.toString());
        movablePoint.setSpeed(5f,1f);
        movablePoint = movablePoint.move();
        System.out.println(movablePoint.toString());
    }
}