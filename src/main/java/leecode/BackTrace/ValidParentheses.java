package leecode.BackTrace;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * 20. 有效的括号
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        //开括号
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                left.push(ch);
            }else{
                if(!left.isEmpty() && (map.get(ch) == left.peek())){
                    left.pop();
                }else{
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int len = 0;
        stack.push(-1);
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                 stack.push(i);
            }else{
                // 遇到右括号，栈顶出栈
                stack.pop();
                //如果栈为空，说明这个是符合条件括号的分割位置，以i为起始再开始
                if(stack.empty()){
                      stack.push(i);
                }else{
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }

}
