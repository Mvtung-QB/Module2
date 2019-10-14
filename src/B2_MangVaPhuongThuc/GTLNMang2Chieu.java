package B2_MangVaPhuongThuc;
import java.util.Scanner;
public class GTLNMang2Chieu {

    public static void main(String[] args) {
        int dai,rong;
        Scanner sc= new Scanner(System.in);
        System.out.println("Chieu dai ma tran");
        dai= sc.nextInt();
        System.out.println("Chieu rong ma tran");
        rong= sc.nextInt();
        int[][] arr= new int[dai][rong];
        // nhap mang
        System.out.println("Nhap mang");
        for (int i=0;i<dai;i++){
            for (int j= 0;j<rong;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        //in mang
        for (int i=0;i<dai;i++){
            for (int j= 0;j<rong;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        // tim gia tri lon nhat
        int max=arr[0][0];
        int x=0,y = 0;
        for ( int i=0;i<dai;i++){
            for (int j= 0;j<rong;j++){
                if (max < arr[i][j]){
                    max = arr[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        System.out.println("max= "+ max+" x= "+ x + " y= "+ y);
    }
}
