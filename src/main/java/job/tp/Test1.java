package job.tp;

import java.util.Arrays;

/**
 * Created by xubo on 2016/9/19.
 */
public class Test1 {
    public static void main(String[] args) {

        int[] array={1,2,3,4};
        System.out.println(new Test1().binary_search(array,array.length,2));
        System.out.println(new Test1().binary_search(array,array.length,4));
    }

    int binary_search(int[] array, int num, int key) {
        return  Arrays.binarySearch(array, key);
    }
}
