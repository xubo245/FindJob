package job.haizhi;//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.HashMap;

class Test {
}

public class Main {
    public static void main(String args[]) {
        ArrayList<HashMap<String, String>> input = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        HashMap<String, String> map3 = new HashMap<String, String>();
        map.put("name”:\"张三\"", "\"type\"：\"个人\"");
        input.add(map);
        map2.put("name”:\"张三\"", "\"type\"：\"董事长\"");
        input.add(map2);
        map3.put("name”:\"李四\"", "\"type\"：\"董事长\"");
        input.add(map3);
        System.out.println(input);
        System.out.println(compute(input));
    }

    /**
     * @param list 输入的list
     * @return 删除重名的list
     */
    public static ArrayList<HashMap<String, String>> compute(ArrayList<HashMap<String, String>> list) {
        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            String key = null;
            for (String keys : list.get(i).keySet()) {
                key = keys;
            }
            if (map.get(key) != null) {
                continue;
            }
            map.put(key, 1);
            result.add(list.get(i));
        }
        return result;
    }
}
