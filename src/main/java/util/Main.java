package util;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N, M;
            N = cin.nextInt();
            M = cin.nextInt();
            int[][] arr = new int[M][2];
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> out = new HashMap<Integer, Integer>();

            int sum = 0;
            for (int i = 0; i < M; i++) {
                arr[i][0] = cin.nextInt()-1;
                arr[i][1] = cin.nextInt()-1;
            }

            int[] a=new int[N];
            int[] b=new int[N];
            boolean[] flagA=new boolean[N];
            boolean[] flagB=new boolean[N];

            for (int i=0;i<M;i++){
                if (flagA[arr[i][0]]==false && flagB[arr[i][1]]==false){
                    flagA[arr[i][0]]=true;
                    flagB[arr[i][1]]=true;
                }else{

                }
            }
            for (int i=0;i<N;i++){
                if (flagB[i]==false){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

}
                       