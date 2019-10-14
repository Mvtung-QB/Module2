package B2_MangVaPhuongThuc;

import java.util.Scanner;

public class TongCacSoTren1Cot {
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
        //-tinh tong cac so tren 1 cot
        System.out.println("nhap cot can tinh tong");
        int c= sc.nextInt();
        int tong=0;
        for (int i=0;i<dai;i++){
            for (int j= 0;j<rong;j++){
                if (j==c )tong+= arr[i][j];
            }
        }
        System.out.println("Tong cot : "+c+" = "+ tong);
    }
}
