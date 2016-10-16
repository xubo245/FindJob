package job.test360;

import java.util.HashMap;
import java.util.Scanner;

class Test {
}

public class Main {
    public static int handle = 1;
    public static int[] handleMem;
    public static HashMap<Integer, Integer> handleMemMap = new HashMap<Integer, Integer>();
//	public static int mem;

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int CMem, time, MaxMem;

        while (cin.hasNextInt()) {
            time = cin.nextInt();
            MaxMem = cin.nextInt();
            CMem = MaxMem;
            // System.out.println(time + MaxMem);
            handleMem = new int[MaxMem];

            for (int i = 0; i < time; i++) {
                String inputString = cin.nextLine();
                String[] inputArr = inputString.split(" ");
                CMem = compute(inputArr, CMem, MaxMem);
            }
        }
    }

    private static int compute(String[] input, int CMem, int Maxmem) {
        // new
        if (input[0].equals("new")) {
            CMem = newMem(input, CMem, Maxmem);
        } else if (input[0].equals("del")) {
            del(Integer.valueOf(input[1]));
        } else if (input[0].equals("def")) {

        }

        // del

        return CMem;

    }

    public static void del(int input) {
        if (handleMemMap.get(input) == null) {
            System.out.println("ILLEGAL_OPERATION");
        } else {
            handleMemMap.remove(input);
            for (int i = 0; i < handleMem.length; i++) {
                if (handleMem[i] == input) {
                    handleMem[i] = 0;
                }
            }
        }


    }

    //    public static void delMem(int input,) {}
    public static boolean HasMem(String[] input) {
        int sum = 0;
        int start = 0;
        for (int i = 0; i < handleMem.length; i++) {

            if (handleMem[i] == 0) {
                sum++;
                continue;
            } else {
                if (Integer.valueOf(input[1]) < sum) {
                    handleMemMap.put(handle, start + Integer.valueOf(input[1]));
                    for (int j = start; j < start + Integer.valueOf(input[1]); j++) {
                        handleMem[j] = handle;
                    }

                    System.out.println(handle);
                    handle++;
                    start = 0;
                    sum = 0;
                    return true;
                } else {
                    if (i < handleMem.length - 1) {
                        for (int k = i + 1; k < handleMem.length; k++) {
                            if (handleMem[k] != handleMem[k-1]) {
                                start = k;
                                break;
                            }
                        }
                    }
                    sum = 0;
                    continue;
                }
            }

        }
        return false;
    }

    public static void handleMemCompute(int length, int start, int value) {
        for (int i = start; i < start + length; i++) {
            handleMem[i] = value;
        }
    }

    public static int newMem(String[] input, int CMem, int Maxmem) {

        if (Integer.valueOf(input[1]) <= CMem) {
            // handleMem.put(input[1], String.valueOf(Maxmem - mem) + "_"
            // + String.valueOf(Maxmem - mem + Integer.valueOf(input[1])));
            int start;
            if (handleMemMap.get(handle - 1) == null) {
                start = 0;
            } else {
                start = handleMemMap.get(handle - 1);
            }

            handleMemCompute(Integer.valueOf(input[1]),
                    start, handle);
            handleMemMap.put(handle, start + Integer.valueOf(input[1]));

            CMem = CMem - Integer.valueOf(input[1]);
            System.out.println(handle);
            handle++;
            return CMem;
        } else if (HasMem(input)) {
            return CMem;
        } else {
            System.out.println("NULL");
            return CMem;
        }
    }
}
