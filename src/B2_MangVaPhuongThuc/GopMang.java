package B2_MangVaPhuongThuc;

public class GopMang {
    public static void main(String[] args) {
        int []x = {5,2,4};
        int []y = {8,5,6,4};
        int[] a= new int[x.length + y.length];
        for (int i=0; i< x.length;i++){
            a[i]= x[i];
        }
        for (int i=0; i< y.length;i++){
            a[x.length+i]= y[i];
        }
        for (int i=0; i< a.length;i++){
            System.out.print(a[i]+ "  ");
        }

    }
}
