package leecode.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        // 存放去重的结果
        Stack<Character> stack = new Stack<>();
        // 维护一个计数器记录字符串中字符的数量，因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for(int i = 0; i<s.length();i++){
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];

        for(char c : s.toCharArray()){
            count[c]--;// 每遍历过一个字符，都将对应的计数减一
            if(inStack[c]){
                continue; //去重, 如果字符 c 存在栈中，直接跳过
            }
            while(!stack.isEmpty() && stack.peek() > c){
                // 若之后不存在栈顶元素了，则停止 pop
                if(count[stack.peek()] == 0){
                    break;
                }
                // 若栈顶元素pop之后后面的字符串中还有该元素，则可以 pop
                inStack[stack.pop()] = false;
            }
            stack.push(c); //若不存在，则插入栈顶并标记为存在
            inStack[c] = true;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
