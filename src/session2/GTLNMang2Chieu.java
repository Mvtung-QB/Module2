package session2;
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
        for (int i=0;i<=dai;i++){
            for (int j= 0;j<=rong;j++){
                arr[i][j]=sc.nextInt();
            }
        }
    }
}
