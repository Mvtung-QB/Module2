package B2_MangVaPhuongThuc;

public class GTNN {
    /**
     * tim gia tri nho nhat trong mang
     *
     * @param arr
     * @return
     */
    static int minArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {1, 6, 8, 9, 5, 4, 5, -1, 4, 2};
        System.out.println(minArray(array));
    }
}
