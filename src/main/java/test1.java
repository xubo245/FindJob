import java.util.TreeMap;

/**
 * Created by xubo on 2016/9/21.
 */
public class test1 {
    public static void main(String[] args) {
        int x=4^6;
        System.out.println(x);
        System.out.println(5^6);
        System.out.println(5^10);
        System.out.println(6^10);
        System.out.println(7^10);
        System.out.println(4^10);
        System.out.println(Integer.MAX_VALUE);
//        for (short i=0;i<Integer.MAX_VALUE;i++){
//            System.out.println(Integer.MAX_VALUE+":"+i);
//        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,32));
        TreeMap<Integer,Integer> map=new TreeMap();
        map.put(1,5);
        map.put(3,5);
        map.put(2,5);
        map.put(11,5);
        map.put(31,5);
        map.put(21,5);
        int[] input=new int[map.size()];
        int index=0;
        for (Object key:map.keySet()){
            input[index]=(Integer) key;
            index++;
        }
        System.out.println(map);
        for (int i=0;i<input.length-1;i++){
            System.out.println(input[i+1]-input[i]);
        }




    }
}
