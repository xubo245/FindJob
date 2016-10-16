package job.tp;

/**
 * Created by xubo on 2016/9/19.
 */
public class Test2 {
    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4,5,6,7,8,9,10};
        int[] array = {1, 3, 1, -3, 5, 3};
        int m = 3;
        for (int i = 0; i < array.length - m + 1; i++) {
            System.out.print(slide(array, i, m) + " ");
        }

    }

    public static int slide(int[] arr, int n, int m) {
        int max = 0;
        for (int i = n; i < n + m; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
