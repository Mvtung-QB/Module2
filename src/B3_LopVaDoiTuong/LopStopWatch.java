package B3_LopVaDoiTuong;


import java.util.Date;
import java.util.Calendar;
import java.util.Random;

public class LopStopWatch {
    public static Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
    public static void main(String[] args) {
    StopWatch st = new StopWatch();
    st.start();
    Integer[]a= createRandom();
    int max=a[0];
        for (int i = 1; i < a.length; i++) {
            if (max<a[i]){
                max=a[i];
            }
        }
        System.out.println("\nmax= "+max );
        st.stop();
        System.out.println("time = "+ st.getElapsedTime());
    }

}
class StopWatch{
    private Date startTime, endTime;
    public StopWatch(){
    }
    public Date getStartTime(){
        return this.startTime;
    }
    public Date getEndTime(){
        return this.endTime;
    }

    public Date start() {
        return this.startTime = Calendar.getInstance().getTime();
    }
    public Date stop() {
        return this.endTime = Calendar.getInstance().getTime();
    }
    //
    public int getElapsedTime(){
       int m = this.startTime.getSeconds();
       int n= this.endTime.getSeconds();
       return n-m;
    }
}