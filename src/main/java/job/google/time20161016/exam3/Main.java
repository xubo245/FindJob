package job.google.time20161016.exam3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dieeasy on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {

        String filename = "F:\\D31.in";
        File out = new File("F:\\D31.out");
        File file = new File(filename);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedwriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedwriter = new BufferedWriter(new FileWriter(out));
            int sum = 0;
            String tmpString = null;
            if ((tmpString = bufferedReader.readLine()) != null) {
                sum = Integer.valueOf(tmpString.trim());
            }
            tmpString = null;
            for (int i = 0; i < sum; i++) {
                int V = 0, S = 0;
                if ((tmpString = bufferedReader.readLine()) != null) {
                    String[] input = tmpString.split(" ");
                    V = Integer.valueOf(input[0]);
                    S = Integer.valueOf(input[1]);
                }
                String[] a = new String[V];
                String[] b = new String[S];
                for (int j = 0; j < V; j++) {
                    if ((tmpString = bufferedReader.readLine().trim()) != null) {
                        a[j] = tmpString;
                    }
                }
                for (int j = 0; j < S; j++) {
                    if ((tmpString = bufferedReader.readLine()) != null) {
                        b[j] = tmpString;
                    }
                }
                compute(a, b, i + 1, bufferedwriter);

            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void compute(String[] a, String[] b, int num, BufferedWriter bufferedwriter) {
        boolean finish = true;
        int sum = 0;
        System.out.print("Case #" + num + ": ");
        String outString = "Case #" + num + ": ";
        try {
            bufferedwriter.write(outString);
            bufferedwriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < b.length; i++) {
            sum = getNum(a, b[i]);
            if (i == b.length - 1) {
                System.out.print(sum + "\n");
                try {
                    bufferedwriter.write(sum + "\n");
                    bufferedwriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print(sum + " ");
                try {
                    bufferedwriter.write(outString + " ");
                    bufferedwriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static int getNum(String[] a, String str) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int index = 0;
            if (str == null) {
                return 0;
            }
            for (int j = 0; j < str.length(); j++) {
                boolean flag = true;
                for (int k = 0; k < a[i].length(); k++) {
                    if (j + a[i].length() <= str.length()) {
                        if (!str.substring(j, j + a[i].length()).contains(a[i].substring(k, k + 1))) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    if (map.get(a[i]) != null) {
                        List list = map.get(a[i]);
                        list.add(j);
                        map.put(a[i], list);
                    } else {
                        List list = new ArrayList<>();
                        list.add(j);
                        map.put(a[i], list);
                    }
                }
            }
        }

        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                List list = map.get(key);
                for (int i = 0; i < list.size(); i++) {
                    if (map2.get(list.get(i)) != null) {
                        List list1 = map2.get(list.get(i));
                        list1.add(key.length());
                        map2.put((Integer) list.get(i), list1);
                    } else {
                        List list1 = new ArrayList<>();
                        list1.add(key.length());
                        map2.put((Integer) list.get(i), list1);
                    }

                }
            }
        }

        return getNum2(map2, 0, str.length());
    }

    public static int getNum2(HashMap<Integer, List<Integer>> map, int n, int N) {
        int sum = 0;

        if (map.get(n) != null) {
            List list = map.get(n);
            for (int j = 0; j < list.size(); j++) {
                int num = (int) list.get(j);
                if ((n + num) == N) {
                    sum=sum+ 1;
                } else if ((n + num) > N) {
                    sum=sum+ 0;
                }
                sum = sum + getNum2(map, (n + num), N);
            }
        }
        return sum;

    }
}
