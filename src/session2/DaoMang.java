package session2;

public class DaoMang {
    public static void main(String[] args) {
        int[] array = {1,6,8,9,5,4,5,4,2};
        int giatri;
        for (int i=0; i<=(array.length)/2;i++){
                giatri = array[i];
                array[i]=array[(array.length-1) -i];
                array[(array.length-1) -i]= giatri;
        }
        for (int i=0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}
