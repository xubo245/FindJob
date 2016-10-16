package util.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by xubo on 2016/9/23.
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap map=new HashMap();
        map.put(1,1);
        map.put(null,2);
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }

        System.out.println();

        LinkedHashMap linkedHashMap=new LinkedHashMap();
        linkedHashMap.put(3,1);
        linkedHashMap.put(null,1);
        linkedHashMap.put(1,1);
        linkedHashMap.put(2,1);
         keySet = linkedHashMap.keySet();
        for (Object key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }
    }

}
