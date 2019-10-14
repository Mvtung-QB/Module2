package session2;
import java.util.Scanner;
public class GiaTriLonNhat {

    public static void main(String[] args) {
        int[] array = {1,6,8,9,5,4,5,4,2};
        int max = array[0];
        for (int i=1; i<array.length;i++){
            if (max < array[i]){
                max = array[i];
            }
        }
        System.out.println("Gia tri lon nhat: "+max);
    }
}
