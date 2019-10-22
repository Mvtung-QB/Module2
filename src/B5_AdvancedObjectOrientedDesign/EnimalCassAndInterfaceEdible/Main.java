package B5_AdvancedObjectOrientedDesign.EnimalCassAndInterfaceEdible;

public class Main {
    public static void main(String[] args) {
        Enimal enimal[]= new Enimal[2];
        enimal[0]= new Chicken();
        enimal[1]= new Tiger();
        for (Enimal e:  enimal) {
            System.out.println(e.makeSound());
            if (e instanceof Chicken){
                System.out.println(((Chicken) e).howToEat());
            }
        }
        Fruit f[]= new Fruit[2];
        f[0]= new Apple();
        f[1]= new Orange();
        for (Fruit e: f) {
            System.out.println(e.howToEat());
        }
    }
}
