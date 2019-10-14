package session2;

import java.util.Scanner;

public class TimGiaTriTrongMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {1,6,8,9,5,4,5,4,2};
        System.out.println("enter number");
        int number = sc.nextInt();
        int d=0;
        for (int i=0; i<array.length;i++){
            if (array[i]==number){
                System.out.println("Position of the number in the list " + number + " is: " + (i + 1));
                d=1;
                break;
            }
        }
        if (d==0){
            System.out.println("Not found");
        }
    }
}
