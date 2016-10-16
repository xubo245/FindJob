package job.google.time20160911.test3.额231;//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int p = in.nextInt();
//            int[][] a = new int[n][m];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    a[i][j] = in.nextInt();
//
//                }
//            }
//            ArrayList<LocationA> list=new ArrayList<LocationA>();
//            compute(a, n, m,p,list);
////            print(a, n, m);
//
//
//
//        }
//    }
//
//
//    public static void compute(int[][] a, int n, int m,int p,  ArrayList<LocationA> list) {
//        int indexn=0;
//        int indexm=0;
//        for (int i=indexn;i<n;i++){
//            for (int j=indexm;j<m;j++){
//                if (j<m-1 && a[i][j+1]==1){
//                    list.add(new LocationA(i,j));
//
//                }else if(i<n-1 && a[i+1][j]==1){
//                    list.add(new LocationA(i,j));
//                    indexm=j;
//                    continue;
//                }
//
//            }
//        }
//
//        for (int i=0;i<list.size();i++ ){
//            System.out.println("["+l.i+","+l.j+"]");
//        }
//
//    }
//    public static void print(int[][] a, int n, int m) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
//class LocationA{
//    int i;
//    int j;
//
//    public LocationA(int i, int j) {
//        this.i = i;
//        this.j = j;
//    }
//}