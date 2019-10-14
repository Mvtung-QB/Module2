package B2_MangVaPhuongThuc;
import java.util.Scanner;
public class DemKyTuTrongChuoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "toi moi hoc java";
        char a = sc.next().charAt(0);
        int dem=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)== a ) {
                dem++;
            }
        }
        if (dem==0) System.out.println("Khong Xuat hien");
        else System.out.println(a+ " Xuat hien "+ dem+ " lan");
    }

}
