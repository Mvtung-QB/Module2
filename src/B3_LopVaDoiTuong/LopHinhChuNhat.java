package B3_LopVaDoiTuong;

class Rectangle {
    int weight;
    int height;

    public Rectangle() {

    }

    public Rectangle(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return this.height * this.weight;
    }
    public int getPerimeter(){
        return (this.height + this.weight) *2;
    }
    public void display(){
        System.out.println("Dien tich: "+ getArea()+ " Chu Vi: "+ getPerimeter());
    }
}
public class LopHinhChuNhat{
    public static void main(String[] args) {
        Rectangle r= new Rectangle(10,15);
        r.display();
    }
}
