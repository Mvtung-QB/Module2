package B3_LopVaDoiTuong;

class PanClass {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;

    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PanClass(){}

    @Override
    public String toString() {
        if (this.on){
            return "speed: "+ this.speed + "clor: "+ this.color+ "radius: "+ this.radius+ " Fast is on";
        }else
            return "clor: "+ this.color+ "radius: "+ this.radius+ " Fast is off";
    }
}
class Pan{
    public static void main(String[] args) {
        PanClass fast = new PanClass();
        fast.setOn(true);
        System.out.println(fast.toString());
    }
}