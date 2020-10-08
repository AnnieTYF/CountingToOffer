package Autumn;

import java.util.Stack;

public class Bigo4 {
    /**
     * 字符串 ，找出1个数字类型，反转输出
     * ab.12a3
     * 输出3.2.1
     * 栈 栈顶 .
     */
    public String solution(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        int count = 0;
        for(int i = 0; i<chs.length ; i++){
            if(Character.isDigit(chs[i])){
                stack.push(chs[i]);
                sb.append(chs[i]);
            }else if(chs[i] == '.'){
                count++;
                sb.append(chs[i]);
            }
        }
        if(count > 1){
            return "error";
        }
        return sb.reverse().toString();
    }

}
