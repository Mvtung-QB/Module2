package B2_MangVaPhuongThuc;
import java.util.Scanner;
public class XoaPhanTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]a= new int[6];
        a[0]=2;
        a[1]=5;
        a[2]=6;
        a[3]=7;
        System.out.println("Phan tu can xoa");
        int x= sc.nextInt();
        int index=-1;
        for (int i= 0; i<a.length;i++){
            if (x== a[i]){
                index =i;
            }
        }
        if (index== -1) {
            System.out.println("Khong co");
        }
        else if(index== a.length-1) {
                a[a.length-1]=0;
                }else{
                        for (int i= index; i<a.length-1;i++){
                            a[i]=a[i+1];
                        }
                        a[a.length-1]=0;
                    }
        //- in mang
        for (int i= 0; i<a.length;i++){
            System.out.print(a[i]+ " ");
        }
    }
}
