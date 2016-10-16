package job.qiniu.exam3.program3; /**
 * @author xubo
 * ref http://www.cnblogs.com/xiaomoxian/p/5189782.html
 */

import java.util.Scanner;

/**
 描述：
 [算法]数组排序之后相邻数的最大差值
 题目：
 给定一个整形数组arr，返回排序后的相邻两数的最大差值。
 时间复杂度为O(N)。


 数据：
 输入：
 4
 5 1 4 7
 输出：
 3

 */
class Test {
}


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n, m;
            n = cin.nextInt();
           int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]= cin.nextInt();
            }
            System.out.println(maxGap(a));

        }
    }

    public static int compute() {
        int sum = 0;
        return sum;
    }
    public static int maxGap(int[] nums) {

        if (nums == null || nums.length < 2) {

            return 0;

        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max); // 算出桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= len) {
            if (hasNum[i++]) { //找到第一个不为空的桶
                lastMax = maxs[i - 1];
                break;
            }

        }

        for (; i <= len; i++) {

            if (hasNum[i]) {

                res = Math.max(res, mins[i] - lastMax);

                lastMax = maxs[i];

            }

        }

        return res;

    }

    //使用long类型是为了防止相乘时溢出

    public static int bucket(long num, long len, long min, long max) {

        return (int) ((num - min) * len / (max - min));

    }

}
                       