package FuramaResort.Views;

import FuramaResort.Controllers.MainControler;

public class Main {
    public static void main(String[] args) {
        MainControler main = new MainControler();
        while (true) {
            main.displayMainMenu();
        }
    }
}
