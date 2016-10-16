package job.tp;

/**
 * Created by xubo on 2016/9/19.
 */
public class Test11 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4,5,6,7,8,9,10};
        System.out.println(new Test11().binary_search(array, array.length, 2));
        System.out.println(new Test11().binary_search(array, array.length, 4));
    }

    int binary_search(int[] array, int num, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == array[middle]) {
                return middle;
            } else if (key < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
