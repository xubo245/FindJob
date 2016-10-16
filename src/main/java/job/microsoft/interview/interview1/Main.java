/**
 * 微软内推一面面试题：
 * 输入一个字符串文本，统计里面有多少个单词？返回为单词数量，分隔符有， . ； ： "和空格等六种
 *
 */
package job.microsoft.interview.interview1;

public class Main {
    public static void main(String args[]) {
        System.out.println(wordCount("hello world"));
        System.out.println(wordCount(" hello world"));
        System.out.println(wordCount("hello world "));
        System.out.println(wordCount("hello world. "));
        System.out.println(wordCount("I am student."));
        System.out.println(wordCount("I am student.I am student"));
        System.out.println(wordCount("I am student, I am student"));
        System.out.println(wordCount("I am student, \"I am student\""));
        System.out.println(wordCount("I am,.: student, \"I am student\""));
        System.out.println(wordCount(""));
        System.out.println(wordCount(" "));
        System.out.println(wordCount("hello"));
    }

    public static int wordCount(String str) {
        int sum = 0;
        boolean flag = true;
        if (str == null) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ") || str.substring(i, i + 1).equals(",") || str.substring(i, i + 1).equals(".") || str.substring(i, i + 1).equals(";") || str.substring(i, i + 1).equals(":") || str.substring(i, i + 1).equals("\"")) {
                if (!flag) {
                    sum++;
                    flag = true;
                }
            } else {
                flag = false;
            }
        }
        if (!flag) {
            sum++;
        }
        return sum;
    }

}
                       