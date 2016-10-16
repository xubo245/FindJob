package job.wanmei; /**
 * Created by xubo on 2016/8/6.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<returnClass> returnClassArrayList = new ArrayList<returnClass>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int start = in.nextInt();
        int end = in.nextInt();
        ArrayList<Trip> list = new ArrayList<Trip>();
        while (in.hasNextInt()) {//注意while处理多个case

            int input1 = in.nextInt();
            int input2 = in.nextInt();
            int input3 = in.nextInt();
            list.add(new Trip(input1, input2, input3));
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        Node node = new Node(start, 0, false, String.valueOf(start));
        Node node0 = build(start, end, list, node);
        find(start, end, node, Integer.MIN_VALUE);

        int max = 0;
        int maxIndex = 0;
        returnClass maxReturn = null;
        if (returnClassArrayList.size() > 1) {
            maxReturn = new returnClass(returnClassArrayList.get(0).string, returnClassArrayList.get(0).value);
        }
        for (int i = 0; i < returnClassArrayList.size(); i++) {
            if (maxReturn.value > returnClassArrayList.get(i).value) {
                maxReturn = returnClassArrayList.get(i);
            }
        }
        System.out.println(maxReturn.string + "(" + maxReturn.value + ")");
    }

    public static void find(int start, int end, Node node, int min) {
        if (node.flag == true) {
            //            return node.value;
            returnClassArrayList.add(new returnClass(node.string, node.value));
        } else {
            for (int i = 0; i < node.arrayList.size(); i++) {
                find(node.arrayList.get(i).id, end, node.arrayList.get(i), min);
            }
        }

    }

    public static Node build(int start, int end, ArrayList<Trip> list, Node node) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).start == node.id) {
                if (list.get(i).end == end) {
//                    node.flag = true;
                    node.arrayList.add(new Node(list.get(i).end, (list.get(i).size + node.value), true, node.string+"=>" + list.get(i).end));
                } else {
//                    if (node.stringBuffer == null) {
//                        node.arrayList.add(new Node(list.get(i).end, (list.get(i).size + node.value), false, new StringBuffer(list.get(i).end)));
//                    }else{
                    String bf = node.string + "=>" + list.get(i).end;
                    node.arrayList.add(new Node(list.get(i).end, (list.get(i).size + node.value), false,bf ));
//                    }
                }

                if (node.Max < node.value) {
                    node.Max = node.value;
                }


            }
//            System.out.println(list.get(i));
        }

//        System.out.println(node.value);
        if (node.arrayList != null && node.flag == false) {
            for (Node node1 : node.arrayList) {
                node = build(node1.id, end, list, node1);
            }
        }
        return node;
    }

}

class returnClass {
    int value;
    String string;

    public returnClass(String string, int value) {
        this.string = string;
        this.value = value;
    }

//    public returnClass(returnClass returnClass) {
//    }
}

class Node {
    int id;
    int value;
    int Max;
    boolean flag = false;
    String string = new String();
    ArrayList<Node> arrayList = new ArrayList<Node>();

    public Node(int id, int value, boolean flag, String string) {
        this.id = id;
        this.value = value;
        this.flag = flag;
        this.string = string;
    }
}

class Trip {
    int start;
    int end;
    int size;

    public Trip(int start, int end, int size) {
        this.start = start;
        this.end = end;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", size=" + size +
                '}';
    }
}