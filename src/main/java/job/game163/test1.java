package game163;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubo on 2016/9/18.
 */
public class test1 {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(9);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        list.add(2,3);
        list.add(5,7);
        list.remove(0);
        System.out.println();
        for (int i=0;i<list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
        System.out.println(list.contains(5));
        System.out.println(list.contains(6));
        List list1=list.subList(0,1);
        System.out.println();
        for (int i=0;i<list1.size();i++){
            System.out.println(i+":"+list1.get(i));
        }
    }

}
