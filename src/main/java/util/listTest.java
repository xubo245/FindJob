package util;

import java.util.ArrayList;

/**
 * Created by xubo on 2016/8/6.
 */
public class listTest {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add(3);
        list.add(5);
        for (int i=0;i<list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
    }
}
