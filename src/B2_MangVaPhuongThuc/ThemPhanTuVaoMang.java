package B2_MangVaPhuongThuc;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import java.util.Scanner;
import java.util.Arrays;
public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int arr[]= new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mang");
        for (int i=0;i<10;i++){
                arr[i]=sc.nextInt();
            }
        //in mang
        System.out.println(Arrays.toString(arr));//in mang arr
        System.out.println("enter element");
        int element= sc.nextInt();
        int i;
        do {
            System.out.println("enter index");
            i= sc.nextInt();
        }while (i<0||i>arr.length);
        int newArr[]= new int[arr.length+1];
        System.arraycopy(arr,0,newArr,0,arr.length);
        if (i==arr.length){
            {
                int value= newArr[newArr.length-2];
                    newArr[newArr.length-2]=element;
                    newArr[newArr.length-1]=value;
                System.out.println(Arrays.toString(newArr));//in mang newarr
            }
        }else {
            for (int j = 0; j < newArr.length; j++) {
                if (i <= j) {
                    int value = newArr[j];
                    newArr[j] = element;
                    element = value;
                }
            }
            System.out.println(Arrays.toString(newArr));//in mang arr
        }
        // chen element vao mang
    }
}
