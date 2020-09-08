package leecode.String;

import java.util.Stack;

public class Calculate {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //记录算式中的数字
        int num = 0;
        //记录 num 前的符号，初始化为 +
        char sign = '+';
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            //如果不是数字，就是遇到了下一个符号，之前的数字和符号就要存进栈中
            if(!Character.isDigit(c) && (c !=' ') || i == s.length() - 1){
                int pre;
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre*num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre/num);
                        break;
                }
               // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }
        //将栈中所有结果求和就是答案
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

    public static void main(String args[]) {
        String s = "3+2*2";
        System.out.println(calculate(s) );
    }
}
