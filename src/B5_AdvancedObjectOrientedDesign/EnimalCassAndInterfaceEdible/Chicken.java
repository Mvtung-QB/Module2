package B5_AdvancedObjectOrientedDesign.EnimalCassAndInterfaceEdible;

 public class Chicken extends Enimal implements Edible{
     @Override
     String makeSound() {
         return "chip";
     }

     @Override
     public String howToEat() {
         return "eat ??" ;
     }
 }
