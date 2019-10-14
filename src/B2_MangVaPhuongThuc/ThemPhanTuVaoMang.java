package B2_MangVaPhuongThuc;
import java.util.Scanner;
import java.util.Arrays;
public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int arr[]= new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter element");
        int element= sc.nextInt();
        int i;
        do {
            System.out.println("enter index");
            i= sc.nextInt();
        }while (i<0||i>arr.length-1);
        arr[i]=element;// chen element vao mang
        System.out.println(Arrays.toString(arr));//in mang arr
    }
}
