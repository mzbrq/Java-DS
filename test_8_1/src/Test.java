import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            func(s);
        }
    }

    public static void func(String s) {
        char[] chArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chArr.length; i++) {
            if (!stack.isEmpty() && stack.peek() == chArr[i]) {
                //出栈
                stack.pop();

            } else {
                //入栈
                stack.add(chArr[i]);
            }
        }

        if (!stack.isEmpty()) {
            char[] tmpArr = new char[stack.size()];

            for (int j = tmpArr.length-1; j >= 0; j--) {
                tmpArr[j] = stack.pop();
            }

            String ret = String.valueOf(tmpArr);
            System.out.println(ret);
        } else  {
            System.out.println(0);
        }

    }
}
