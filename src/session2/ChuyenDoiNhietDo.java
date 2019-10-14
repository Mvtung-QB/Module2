package session2;
import java.util.Scanner;
public class ChuyenDoiNhietDo {
    public static double fahrenheitToCelsius(double fahrenheit){
        return  (5.0 / 9) * (fahrenheit - 32);
    }
    public static double celsiusToFahrenheit(double celsius){
        return  (9.0 / 5) * celsius + 32;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double fahrenheit,celsius;
        int c;
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.println("enter Fahrenheit: ");
                    fahrenheit = sc.nextDouble();
                    System.out.println(fahrenheit+ " Fahrenheit = "+celsiusToFahrenheit(fahrenheit)+" Celsius");
                    break;
                case 2:
                    System.out.println("enter celsius: ");
                    celsius = sc.nextDouble();
                    System.out.println(celsius+ " Celsius = "+fahrenheitToCelsius(celsius)+" Fahrenheit");
                    break;
                case 0:
                    System.exit(0);
            }
        } while (c != 0);
    }
}
