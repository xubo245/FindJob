package job.haizhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by xubo on 2016/10/12.
 */
public class Main2 {
    public static void main(String[] args) {
        ArrayList<Person> input = new ArrayList<Person>();
        input.add(new Person("张三", "个人"));
        input.add(new Person("张三", "董事长"));
        input.add(new Person("李四", "董事长"));
        System.out.println(new Person("张三", "个人").equals(new Person("张三", "董事长")));
        System.out.println(input);
        System.out.println(compute(input));
    }

    /**
     * 计算操作
     *
     * @param list 输入Person list
     * @return 删除好的数据
     */
    public static ArrayList<Person> compute(ArrayList<Person> list) {
        ArrayList<Person> result = new ArrayList<Person>();
        boolean[] flag = new boolean[list.size()];
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == null) {
                map.put(list.get(i), 1);
            }
        }
        Set keySet = map.keySet();
        for (Object a : keySet) {
            result.add((Person) a);
        }
        return result;
    }
}

/**
 * 数据存储类
 */
class Person {
    private String name;
    private String type;

    public Person(String name, String type) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name.equals(person.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

